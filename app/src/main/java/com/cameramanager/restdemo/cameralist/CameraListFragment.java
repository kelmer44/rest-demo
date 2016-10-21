package com.cameramanager.restdemo.cameralist;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.cameramanager.restdemo.R;
import com.cameramanager.restdemo.cameradetail.CameraDetailActivity;
import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraTree;
import com.cameramanager.restdemo.data.model.User;
import com.cameramanager.restdemo.data.model.Zone;
import com.cameramanager.restdemo.service.CMService;
import com.cameramanager.restdemo.zones.ZonesContract;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public class CameraListFragment extends Fragment implements CameraListContract.View {

    private static final String TAG = "CameraListFragment";
    private CameraListContract.Presenter mPresenter;
    CamerasItemListener mCamerasItemListener = new CamerasItemListener() {
        @Override
        public void onCameraClick(final Camera clickedCamera) {
            mPresenter.openCameraDetails(clickedCamera);
        }
    };
    private CamerasAdapter mCamerasAdapter;
    private PopupMenu mPopupMenu;
    private List<Zone> mZoneList;

    public CameraListFragment() {
    }

    public static CameraListFragment newInstance() {
        return new CameraListFragment();
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCamerasAdapter = new CamerasAdapter(new ArrayList<Camera>(0), mCamerasItemListener);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cameras, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.camera_list);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(mCamerasAdapter);

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.refresh_layout);
        swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark)
        );

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadCameras(false);
            }
        });

        setHasOptionsMenu(true);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.camera_list_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_filter:

                if (mPopupMenu == null) {
                    mPopupMenu = new PopupMenu(getContext(), getActivity().findViewById(R.id.menu_filter));
                }
                mPopupMenu.getMenu().clear();
                for (int i = 0; i < mZoneList.size(); i++) {
                    final Zone zone = mZoneList.get(i);
                    mPopupMenu.getMenu().add(Menu.NONE, zone.getZoneId().intValue(), i, zone.getName());
                }
                mPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        mPresenter.setFiltering(item.getItemId());
                        mPresenter.loadCameras(false);
                        return true;
                    }
                });
                mPopupMenu.show();
                break;
            case R.id.menu_refresh:
                mPresenter.loadCameras(true);
                break;
        }
        return true;
    }

    @Override
    public void setPresenter(@NonNull final CameraListContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }
        final SwipeRefreshLayout srl =
                (SwipeRefreshLayout) getView().findViewById(R.id.refresh_layout);
        // Make sure setRefreshing() is called after the layout is done with everything else.
        srl.post(new Runnable() {
            @Override
            public void run() {
                srl.setRefreshing(active);
            }
        });
    }

    @Override
    public void showLoadingCamerasError() {
        showMessage(getString(R.string.error_loading_cameras));
    }

    private void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showCameras(List<Camera> cameras) {
        mCamerasAdapter.replaceData(cameras);
    }

    @Override
    public void showNoCameras() {

    }

    @Override
    public void showCameraDetails(final Long cameraId) {
        //In its own Activity, since it makes more sense that way
        Intent intent = new Intent(getContext(), CameraDetailActivity.class);
        intent.putExtra(CameraDetailActivity.EXTRA_CAMERA_ID, cameraId);
        startActivity(intent);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void showLoadingUserError() {
        showMessage(getString(R.string.error_loading_user));
    }

    @Override
    public void showUser(final User user) {
        final NavigationView drawerLayout = (NavigationView) getActivity().findViewById(R.id.nav_view);
        final View headerView = drawerLayout.getHeaderView(0);
        final TextView userName = (TextView) headerView.findViewById(R.id.username_header);
        final TextView userEmail = (TextView) headerView.findViewById(R.id.tv_email);
        userName.setText(String.format("%s %s", user.getGivenName(), user.getFamilyName()));
        userEmail.setText(user.getEmail());
    }

    //    @Override
    public void loadFilter(final List<Zone> zoneList) {
        mZoneList = zoneList;
    }

    public interface CamerasItemListener {
        void onCameraClick(Camera clickedCamera);
    }

    public class CamerasAdapter extends RecyclerView.Adapter<CamerasAdapter.CameraViewHolder> {

        private List<Camera> mCameras;
        private CamerasItemListener mCameraItemListener;


        public CamerasAdapter(List<Camera> cameras, CamerasItemListener itemListener) {
            setList(cameras);
            mCameraItemListener = itemListener;
        }

        public void setList(final List<Camera> list) {
            mCameras = checkNotNull(list);
        }

        public void replaceData(final List<Camera> cameras) {
            setList(cameras);
            notifyDataSetChanged();
        }


        @Override
        public CameraViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View rowView = inflater.inflate(R.layout.camera_item, parent, false);
            return new CameraViewHolder(rowView);
        }

        @Override
        public void onBindViewHolder(final CameraViewHolder holder, final int position) {
            final Camera camera = mCameras.get(position);
            holder.titleTextView.setText(camera.getName());
            holder.recordingSwitch.setChecked(camera.getOnline());
            Picasso.with(CameraListFragment.this.getContext()).load(CMService.buildSnapshotUrl(camera.getCameraId())).into(holder.cameraPreview);
            holder.containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    mCameraItemListener.onCameraClick(camera);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mCameras.size();
        }

        public class CameraViewHolder extends RecyclerView.ViewHolder {
            TextView titleTextView;
            ImageView cameraPreview;
            View containerView;
            Switch recordingSwitch;

            public CameraViewHolder(View itemView) {
                super(itemView);
                containerView = itemView;
                titleTextView = (TextView) itemView.findViewById(R.id.camera_title);
                cameraPreview = (ImageView) itemView.findViewById(R.id.camera_preview_image);
                recordingSwitch = (Switch) itemView.findViewById(R.id.recording_switch);
            }
        }


    }
}
