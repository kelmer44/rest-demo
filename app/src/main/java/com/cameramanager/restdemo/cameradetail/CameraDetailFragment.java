package com.cameramanager.restdemo.cameradetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cameramanager.restdemo.R;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public class CameraDetailFragment extends Fragment implements CameraDetailContract.View {

    private static final String ARGUMENT_CAMERA_ID = "camera_id";
    @NonNull
    private CameraDetailContract.Presenter mPresenter;


    private TextView mCameraTitle;


    @Override
    public void setPresenter(@NonNull CameraDetailContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);;
    }

    public static CameraDetailFragment newInstance(final Long cameraId) {
        final Bundle arguments = new Bundle();
        arguments.putLong(ARGUMENT_CAMERA_ID, cameraId);
        CameraDetailFragment fragment = new CameraDetailFragment();
        fragment.setArguments(arguments);
        return fragment;
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
        View root = inflater.inflate(R.layout.fragment_cameradetail, container, false);
        setHasOptionsMenu(true);

        mCameraTitle = (TextView) root.findViewById(R.id.camera_name_title);

        return root;
    }


    @Override
    public void showName(final String name) {
        mCameraTitle.setText(name);
    }

    @Override
    public void showMissingCamera() {

    }

    @Override
    public void setLoadingIndicator(final boolean active) {

    }
}
