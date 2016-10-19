package com.cameramanager.restdemo.data.source;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.User;

import rx.Observable;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/19/2016.
 */

public class UserRepository implements UserDataSource {
    private static UserRepository INSTANCE = null;


    private final UserDataSource mUserLocalDataSource;
    private final UserDataSource mUserRemoteDataSource;


    @Override
    public Observable<User> getSelf() {
        return mUserRemoteDataSource.getSelf();
    }


    private UserRepository(@NonNull UserDataSource userLocalDataSource, @NonNull UserDataSource userRemoteDataSource){
        mUserLocalDataSource = checkNotNull(userLocalDataSource);
        mUserRemoteDataSource = checkNotNull(userRemoteDataSource);
    }

    public static UserRepository getInstance(UserDataSource remoteDataSource,
                                             UserDataSource localDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository(localDataSource, remoteDataSource);
        }
        return INSTANCE;
    }



}
