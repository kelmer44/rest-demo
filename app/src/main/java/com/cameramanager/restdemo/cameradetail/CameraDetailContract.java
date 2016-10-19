package com.cameramanager.restdemo.cameradetail;

import com.cameramanager.restdemo.BasePresenter;
import com.cameramanager.restdemo.BaseView;
import com.cameramanager.restdemo.data.model.CameraStream;
import com.cameramanager.restdemo.data.model.capabilities.CameraCapabilities;

import java.util.List;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public interface CameraDetailContract {

    interface View extends BaseView<Presenter> {

        void showName(String name);

        void showMissingCamera();

        void setLoadingIndicator(boolean active);

        void showScreencap(Long cameraId);

        void setVideoLoadingIndicator(boolean active);

        void loadVideo(CameraStream cameraStream);

        void play();

        void stop();

        void showCapabilities(List<CameraDetailPresenter.DataValue> camera);
    }

    interface Presenter extends BasePresenter {

    }
}
