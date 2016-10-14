package com.cameramanager.restdemo.data.source;

import java.util.List;

/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */

public interface ZonesDataSource {

    interface LoadZonesCallback {

        void onZonesLoaded(List<Zone> tasks);

        void onDataNotAvailable();

    }
    interface  GetZoneCallback {

        void onZoneLoaded(Zone zone);

        void onDataNotAvailable();

    }


    void getZones(LoadZonesCallback loadZonesCallback);
}
