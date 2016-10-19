package com.cameramanager.restdemo.data.source.remote;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.User;
import com.cameramanager.restdemo.data.source.UserDataSource;
import com.cameramanager.restdemo.service.CMService;
import com.cameramanager.restdemo.service.UserService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Gabriel Sanmartín on 10/19/2016.
 */

public class UserRemoteDataSource implements UserDataSource {

    private static UserRemoteDataSource INSTANCE;

    @NonNull
    private final UserService mUserService;


    public static UserRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRemoteDataSource();
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private UserRemoteDataSource() {

        Retrofit retrofit  = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(CMService.SERVICE_ENDPOINT)
                .build();

        mUserService = retrofit.create(UserService.class);
    }

    @Override
    public Observable<User> getSelf() {
        return mUserService.getSelf();
    }
}
