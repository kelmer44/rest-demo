package com.cameramanager.restdemo.data.source;

import android.content.Context;

import com.cameramanager.restdemo.data.source.local.ZonesLocalDataSource;
import com.cameramanager.restdemo.data.source.remote.ZonesRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */
@Module
public class ZonesRepositoryModule {

    @Singleton
    @Provides
    @Local
    ZonesDataSource provideZonesLocalDataSource(Context context) {
        return new ZonesLocalDataSource(context);
    }

    @Singleton
    @Provides
    @Remote
    ZonesDataSource provideZonesRemoteDataSource() { return new ZonesRemoteDataSource();}

}
