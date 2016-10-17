package com.cameramanager.restdemo.cameralist;

import com.cameramanager.restdemo.BasePresenter;
import com.cameramanager.restdemo.BaseView;
import com.cameramanager.restdemo.data.model.Camera;

import java.util.List;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public interface CameraListContract {

    interface View extends BaseView<CameraListContract.Presenter> {

        void setLoadingIndicator(boolean show);

        void showLoadingCamerasError();

        void showCameras(List<Camera> cameras);

        void showNoCameras();
    }

    interface Presenter extends BasePresenter {

        void openCameraDetails();

        void loadCameras(boolean forceUpdate);
    }
}
