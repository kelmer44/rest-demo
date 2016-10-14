package com.cameramanager.restdemo.cameralist;

import com.cameramanager.restdemo.BasePresenter;
import com.cameramanager.restdemo.BaseView;
import com.cameramanager.restdemo.zones.ZonesContract;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public interface CameraListContract {

    interface View extends BaseView<ZonesContract.Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
