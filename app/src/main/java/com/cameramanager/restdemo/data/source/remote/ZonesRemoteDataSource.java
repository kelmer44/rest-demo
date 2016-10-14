package com.cameramanager.restdemo.data.source.remote;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.Zone;
import com.cameramanager.restdemo.data.source.ZonesDataSource;
import com.cameramanager.restdemo.service.ZoneService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
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

    @NonNull
    private final ZoneService mZoneService;


    public static ZonesRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ZonesRemoteDataSource();
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private ZonesRemoteDataSource() {

        Retrofit retrofit  = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ZoneService.SERVICE_ENDPOINT)
                .build();

        mZoneService = retrofit.create(ZoneService.class);
    }

    @Override
    public Observable<List<Zone>> getZones() {
        return mZoneService.getZones();
    }
}
