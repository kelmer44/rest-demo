package com.cameramanager.restdemo.cameralist;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cameramanager.restdemo.R;
import com.cameramanager.restdemo.zones.ZonesContract;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public class CameraListFragment extends Fragment implements CameraListContract.View{

    public CameraListFragment(){
    }


    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cameras, container, false);
        return root;
    }



    public static CameraListFragment newInstance() {
        return new CameraListFragment();
    }

    @Override
    public void setPresenter(final ZonesContract.Presenter presenter) {

    }
}
