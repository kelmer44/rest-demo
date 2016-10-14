package com.cameramanager.restdemo.zones;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cameramanager.restdemo.R;
import com.cameramanager.restdemo.data.source.Zone;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */

public class ZonesFragment extends Fragment implements ZonesContract.View {

    private ZonesContract.Presenter mPresenter;

    private ZonesAdapter mListAdapter;

    private LinearLayout mZonesView;


    public ZonesFragment() {
        // Requires empty public constructor

    }

    public static ZonesFragment newInstance() {
        return new ZonesFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListAdapter = new ZonesAdapter(new ArrayList<Zone>(0), mItemListener);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_zones, container, false);

        // Set up tasks view
        ListView listView = (ListView) root.findViewById(R.id.zone_list);
        listView.setAdapter(mListAdapter);
        mZonesView = (LinearLayout) root.findViewById(R.id.zones_linear_layout);

        //Set up floatin action button
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_add_zone);

        fab.setImageResource(R.drawable.ic_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                mPresenter.addNewZone();
            }
        });

        //Set up progress indicator
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.refresh_layout);
        swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadZones(false);
            }
        });

        setHasOptionsMenu(true);

        return root;
    }


    /**
     * Listener for clicks on tasks in the ListView.
     */
    ZoneItemListener mItemListener = new ZoneItemListener() {
        @Override
        public void onZoneClick(final Zone clickedZone) {

        }
    };


    @Override
    public void setPresenter(@NonNull final ZonesContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingIndicator(final boolean active) {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void showLoadingZonesError() {
        showMessage(getString(R.string.loading_zones_error));
    }

    private void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showZones(final List<Zone> zones) {
        mListAdapter.replaceData(zones);
        mZonesView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoZones() {

    }

    private static class ZonesAdapter extends BaseAdapter {

        private List<Zone> mZones;
        private ZoneItemListener mZoneItemListener;

        public ZonesAdapter(List<Zone> zones, ZoneItemListener itemListener) {
            setList(zones);
            mZoneItemListener = itemListener;
        }

        public void replaceData(final List<Zone> zones) {
            setList(zones);
            notifyDataSetChanged();
        }

        private void setList(final List<Zone> zones) {
            mZones = checkNotNull(zones);
        }


        @Override
        public int getCount() {
            return mZones.size();
        }

        @Override
        public Zone getItem(final int i) {
            return mZones.get(i);
        }

        @Override
        public long getItemId(final int i) {
            return i;
        }

        @Override
        public View getView(final int i, final View view, final ViewGroup viewGroup) {
            View rowView = view;
            if(rowView == null) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                rowView = inflater.inflate(R.layout.zone_item, viewGroup, false);
            }

            final Zone zone = getItem(i);

            TextView titleTextView = (TextView) rowView.findViewById(R.id.zone_title);
            titleTextView.setText(zone.getName());

            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    mZoneItemListener.onZoneClick(zone);
                }
            });

            return rowView;
        }
    }


    public interface ZoneItemListener {
        void onZoneClick(Zone clickedZone);
    }

}
