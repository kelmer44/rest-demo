package com.cameramanager.restdemo.service;

import com.cameramanager.restdemo.data.model.User;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Gabriel Sanmartín on 10/19/2016.
 */

public interface UserService {

    @GET("users/self")
    Observable<User> getSelf();
}
