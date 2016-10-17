package com.cameramanager.restdemo.cameradetail;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public class CameraDetailFragment extends Fragment implements CameraDetailContract.View {

    @NonNull
    private CameraDetailContract.Presenter mPresenter;



    @Override
    public void setPresenter(final CameraDetailContract.Presenter presenter) {
        checkNotNull(presenter);
        mPresenter = presenter;
    }
}
