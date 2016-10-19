package com.cameramanager.restdemo.data.source.local;

import com.cameramanager.restdemo.data.model.User;
import com.cameramanager.restdemo.data.source.UserDataSource;

import rx.Observable;

/**
 * Created by Gabriel Sanmartín on 10/19/2016.
 */

public class UserLocalDataSource implements UserDataSource {
    @Override
    public Observable<User> getSelf() {
        return null;
    }
}
