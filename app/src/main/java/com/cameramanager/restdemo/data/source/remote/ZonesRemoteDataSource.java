package com.cameramanager.restdemo.data.source.remote;

import com.cameramanager.restdemo.data.model.Zone;
import com.cameramanager.restdemo.data.source.ZonesDataSource;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;


/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */

public class ZonesRemoteDataSource implements ZonesDataSource {

    private static ZonesRemoteDataSource INSTANCE;

    private final static Map<Long, Zone> ZONES_SERVICE_DATA;

    static {
        ZONES_SERVICE_DATA = new LinkedHashMap<>(2);

        final Zone zone = new Zone().withZoneId(1L).withPhone("+34646411871").withName("Test zone").withEmail("zone@zone.com").withAccountId(333L);
        final Zone zone2 = new Zone().withZoneId(2L).withPhone("+34646411871").withName("Zone 2").withEmail("zone@zone.com").withAccountId(333L);

        ZONES_SERVICE_DATA.put(zone.getZoneId(), zone);
        ZONES_SERVICE_DATA.put(zone2.getZoneId(), zone2);
    }


    public static ZonesRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ZonesRemoteDataSource();
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private ZonesRemoteDataSource() {}

    @Override
    public Observable<List<Zone>> getZones() {
        return Observable
                .from(ZONES_SERVICE_DATA.values())
                .toList();
    }
}
