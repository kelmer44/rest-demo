package com.cameramanager.restdemo.data.source;

import com.cameramanager.restdemo.data.model.User;

import rx.Observable;

/**
 * Created by Gabriel Sanmartín on 10/19/2016.
 */

public interface UserDataSource {
    Observable<User> getSelf();
}
