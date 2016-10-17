package com.cameramanager.restdemo.cameralist;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cameramanager.restdemo.R;
import com.cameramanager.restdemo.cameradetail.CameraDetailActivity;
import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.zones.ZonesContract;

import java.util.ArrayList;
import java.util.List;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public class CameraListFragment extends Fragment implements CameraListContract.View{

    private CamerasAdapter mCamerasAdapter;

    private CameraListContract.Presenter mPresenter;

    public CameraListFragment(){
    }

    @Override
    public void setPresenter(@NonNull final CameraListContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCamerasAdapter = new CamerasAdapter(new ArrayList<Camera>(0), mCamerasItemListener);
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

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cameras, container, false);

        ListView listView = (ListView) root.findViewById(R.id.camera_list);
        listView.setAdapter(mCamerasAdapter);

        setHasOptionsMenu(true);

        return root;
    }



    public static CameraListFragment newInstance() {
        return new CameraListFragment();
    }


    CamerasItemListener mCamerasItemListener = new CamerasItemListener() {
        @Override
        public void onCameraClick(final Camera clickedCamera) {
            mPresenter.openCameraDetails(clickedCamera);
        }
    };

    @Override
    public void setLoadingIndicator(final boolean active) {

    }

    @Override
    public void showLoadingCamerasError() {

    }

    @Override
    public void showCameras(final List<Camera> cameras) {
        mCamerasAdapter.replaceData(cameras);
    }

    @Override
    public void showNoCameras() {

    }

    @Override
    public void showCameraDetails(final Long cameraId) {
        //In its own Activity, since it makes more sanese that way
        Intent intent = new Intent(getContext(), CameraDetailActivity.class);
        intent.putExtra(CameraDetailActivity.EXTRA_CAMERA_ID, cameraId);
        startActivity(intent);
    }

    public static class CamerasAdapter extends BaseAdapter {

        private List<Camera> mCameras;
        private CamerasItemListener mCameraItemListener;

        public CamerasAdapter(List<Camera> cameras, CamerasItemListener itemListener) {
            setList(cameras);
            mCameraItemListener = itemListener;
        }

        public void setList(final List<Camera> list) {
            mCameras = checkNotNull(list);
        }

        @Override
        public int getCount() {
            return mCameras.size();
        }

        @Override
        public Camera getItem(final int i) {
            return mCameras.get(i);
        }

        @Override
        public long getItemId(final int i) {
            return i;
        }

        /**
         *
         */

        @Override
        public View getView(final int i, final View view, final ViewGroup viewGroup) {
            View rowView = view;
            if (rowView == null) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                rowView = inflater.inflate(R.layout.camera_item, viewGroup, false);
            }

            final Camera camera = getItem(i);

            TextView titleTextView = (TextView) rowView.findViewById(R.id.camera_title);
            titleTextView.setText(camera.getName());

            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    mCameraItemListener.onCameraClick(camera);
                }
            });
            return rowView;
        }

        public void replaceData(final List<Camera> cameras) {
            setList(cameras);
            notifyDataSetChanged();
        }
    }

    public interface CamerasItemListener {
        void onCameraClick(Camera clickedCamera);
    }
}
