package com.cameramanager.restdemo.service;

import com.cameramanager.restdemo.data.model.Zone;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */
public interface ZoneService {


    @GET("zones")
    Observable<List<Zone>> getZones();
}
