package com.cameramanager.restdemo.data.source.remote;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.Zone;
import com.cameramanager.restdemo.data.source.ZonesDataSource;
import com.cameramanager.restdemo.service.CMService;
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
                .baseUrl(CMService.SERVICE_ENDPOINT)
                .build();

        mZoneService = retrofit.create(ZoneService.class);
    }

    @Override
    public Observable<List<Zone>> getZones() {
        return mZoneService.getZones();
    }
}
