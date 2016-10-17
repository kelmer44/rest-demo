package com.cameramanager.restdemo.cameralist;

import com.cameramanager.restdemo.BasePresenter;
import com.cameramanager.restdemo.BaseView;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public interface CameraListContract {

    interface View extends BaseView<CameraListContract.Presenter> {

        void setLoadingIndicator(boolean show);
    }

    interface Presenter extends BasePresenter {

        void openCameraDetails();

        void loadCameras(boolean forceUpdate);
    }
}
