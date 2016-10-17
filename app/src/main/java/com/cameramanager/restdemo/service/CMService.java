package com.cameramanager.restdemo.service;

import android.support.annotation.NonNull;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public class CMService {
    public static String SERVICE_ENDPOINT = "http://10.0.0.105:8080/rest/v1.1/";
    public static String SNAPSHOT_PATH = "/snapshot";

    public static String buildSnapshotUrl(@NonNull Long cameraId){
        return SERVICE_ENDPOINT + "cameras/" + cameraId + SNAPSHOT_PATH;
    }


}
