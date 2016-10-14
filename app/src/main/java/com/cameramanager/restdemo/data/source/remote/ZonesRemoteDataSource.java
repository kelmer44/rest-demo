package com.cameramanager.restdemo.data.source.remote;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.source.Zone;
import com.cameramanager.restdemo.data.source.ZonesDataSource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */

public class ZonesRemoteDataSource implements ZonesDataSource {

    private static ZonesRemoteDataSource INSTANCE;

    private final static Map<Long, Zone> ZONES_SERVICE_DATA;

    static {
        ZONES_SERVICE_DATA = new LinkedHashMap<>(2);

        final Zone zone = new Zone(1L, "+34646411871", "Test zone", "zone@zone.com", 333L);
        final Zone zone2 = new Zone(2L, "+34646411871", "Zone 2", "zone@zone.com", 333L);

        ZONES_SERVICE_DATA.put(zone.getZoneId(), zone);
        ZONES_SERVICE_DATA.put(zone2.getZoneId(), zone2);
    }


    // Prevent direct instantiation.
    private ZonesRemoteDataSource() {}

    public static ZonesRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ZonesRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getZones(@NonNull final LoadZonesCallback loadZonesCallback) {
        loadZonesCallback.onZonesLoaded(new ArrayList<Zone>(ZONES_SERVICE_DATA.values()));
    }
}
