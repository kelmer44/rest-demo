package com.cameramanager.restdemo.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.Zone;
import com.cameramanager.restdemo.data.source.ZonesDataSource;


import java.util.List;

import rx.Observable;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */
public class ZonesLocalDataSource implements ZonesDataSource {

    private static ZonesLocalDataSource INSTANCE;

    private ZonesLocalDataSource(@NonNull Context context) {
        checkNotNull(context);
    }

    public static ZonesLocalDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ZonesLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<Zone>> getZones() {
        return null;
    }
}
