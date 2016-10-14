package com.cameramanager.restdemo.zones;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cameramanager.restdemo.R;

import java.util.ArrayList;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */

public class ZonesFragment extends Fragment implements ZonesContract.View {

    private ZonesContract.Presenter mPresenter;

    public ZonesFragment() {

    }

    public static ZonesFragment newInstance() {
        return new ZonesFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_zones, container, false);

        // Set up tasks view
        ListView listView = (ListView) root.findViewById(R.id.zone_list);

        return root;
    }

    @Override
    public void setPresenter(@NonNull final ZonesContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
