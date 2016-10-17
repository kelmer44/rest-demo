package com.cameramanager.restdemo.data.source.remote;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraStream;
import com.cameramanager.restdemo.data.source.CamerasDataSource;
import com.cameramanager.restdemo.service.CameraService;
import com.cameramanager.restdemo.service.ZoneService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public class CamerasRemoteDataSource implements CamerasDataSource {

    private static ZonesRemoteDataSource INSTANCE;

    private CamerasRemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ZoneService.SERVICE_ENDPOINT)
                .build();

        mCameraService = retrofit.create(CameraService.class);
    }


    @NonNull
    private final CameraService mCameraService;

    @Override
    public Observable<List<Camera>> getCameras() {
        return mCameraService.getCameras();
    }

    @Override
    public Observable<Camera> getCamera(final Long cameraId) {
        return mCameraService.getCamera(cameraId);
    }

    @Override
    public Observable<CameraStream> getCameraStreams(final Long cameraId) {
        return mCameraService.getCameraStream(cameraId);
    }
}
