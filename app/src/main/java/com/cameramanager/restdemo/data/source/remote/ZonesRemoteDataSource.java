package com.cameramanager.restdemo.data.source.remote;

import com.cameramanager.restdemo.data.source.ZonesDataSource;


/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */

public class ZonesRemoteDataSource implements ZonesDataSource {

    private static ZonesRemoteDataSource INSTANCE;

    // Prevent direct instantiation.
    private ZonesRemoteDataSource() {}

    public static ZonesRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ZonesRemoteDataSource();
        }
        return INSTANCE;
    }
}
