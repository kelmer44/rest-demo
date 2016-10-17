package com.cameramanager.restdemo.service;


import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraStream;
import com.cameramanager.restdemo.data.model.capabilities.CameraCapabilities;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public interface CameraService {


    @GET("cameras")
    public Observable<List<Camera>> getCameras();

    @GET("cameras/{cameraId}")
    public Observable<Camera> getCamera(@Path("cameraId") Long cameraId);

    @GET("cameras/{cameraId}/streams")
    public Observable<CameraStream> getCameraStream(@Path("cameraId") Long cameraId);

    @GET("cameras/{cameraId}/capabilities")
    public Observable<CameraCapabilities> getCameraCapabilities(@Path("cameraId") Long cameraId);
}
