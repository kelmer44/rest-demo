package com.cameramanager.restdemo.zones;

import com.cameramanager.restdemo.BasePresenter;
import com.cameramanager.restdemo.BaseView;
import com.cameramanager.restdemo.data.source.Zone;

import java.util.List;

/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */

public interface ZonesContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        boolean isActive();

        void showLoadingTasksError();

        void showZones(List<Zone> zones);

        void showNoZones();
    }

    interface Presenter extends BasePresenter {
        void addNewZone();

        void loadZones(boolean forceUpdate);
    }
}
