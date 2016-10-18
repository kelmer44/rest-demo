package com.cameramanager.restdemo.cameralist;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.BasePresenter;
import com.cameramanager.restdemo.BaseView;
import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraTree;

import java.util.List;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public interface CameraListContract {

    interface View extends BaseView<CameraListContract.Presenter> {

        void setLoadingIndicator(boolean show);

        void showLoadingCamerasError();

        void showCameras(CameraTree cameras);

        void showNoCameras();

        void showCameraDetails(Long cameraId);
    }

    interface Presenter extends BasePresenter {

        void openCameraDetails(Camera requestedCamera);

        void loadCameras(boolean forceUpdate);
    }
}
