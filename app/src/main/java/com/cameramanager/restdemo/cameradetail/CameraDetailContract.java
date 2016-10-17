package com.cameramanager.restdemo.cameradetail;

import com.cameramanager.restdemo.BasePresenter;
import com.cameramanager.restdemo.BaseView;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public interface CameraDetailContract {

    interface View extends BaseView<Presenter> {

        void showName(String name);

        void showMissingCamera();

        void setLoadingIndicator(boolean active);
    }

    interface Presenter extends BasePresenter {

    }
}
