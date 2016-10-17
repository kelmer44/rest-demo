package com.cameramanager.restdemo.data.source;

import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraStream;
import com.cameramanager.restdemo.data.model.capabilities.CameraCapabilities;

import java.util.List;

import rx.Observable;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public interface CamerasDataSource {

    Observable<List<Camera>> getCameras();

    Observable<Camera> getCamera(Long cameraId);

    Observable<CameraStream> getCameraStreams(Long cameraId);

    Observable<CameraCapabilities> getCameraCapabilities(Long cameraId);

}
