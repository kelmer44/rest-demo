package com.cameramanager.restdemo.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraStream;
import com.cameramanager.restdemo.data.model.Zone;
import com.cameramanager.restdemo.data.source.CamerasDataSource;

import java.util.List;

import rx.Observable;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public class CamerasLocalDataSource implements CamerasDataSource {

    private static CamerasLocalDataSource INSTANCE;

    private CamerasLocalDataSource(@NonNull Context context) {
        checkNotNull(context);
    }

    public static CamerasLocalDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new CamerasLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<Camera>> getCameras() {
        return null;
    }

    @Override
    public Observable<Camera> getCamera(final Long cameraId) {
        return null;
    }

    @Override
    public Observable<CameraStream> getCameraStreams(final Long cameraId) {
        return null;
    }


}
