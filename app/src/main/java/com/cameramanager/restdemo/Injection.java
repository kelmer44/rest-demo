/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cameramanager.restdemo;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.source.CameraTreeRepository;
import com.cameramanager.restdemo.data.source.CamerasRepository;
import com.cameramanager.restdemo.data.source.UserRepository;
import com.cameramanager.restdemo.data.source.ZonesRepository;
import com.cameramanager.restdemo.data.source.local.CamerasLocalDataSource;
import com.cameramanager.restdemo.data.source.local.UserLocalDataSource;
import com.cameramanager.restdemo.data.source.local.ZonesLocalDataSource;
import com.cameramanager.restdemo.data.source.remote.CamerasRemoteDataSource;
import com.cameramanager.restdemo.data.source.remote.UserRemoteDataSource;
import com.cameramanager.restdemo.data.source.remote.ZonesRemoteDataSource;
import com.cameramanager.restdemo.util.schedulers.BaseSchedulerProvider;
import com.cameramanager.restdemo.util.schedulers.SchedulerProvider;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Enables injection of production implementations for
 * {@link com.cameramanager.restdemo.data.source.ZonesDataSource} at compile time.
 */
public class Injection {

    public static ZonesRepository provideZonesRepository(@NonNull Context context) {
        checkNotNull(context);
        return ZonesRepository.getInstance(ZonesRemoteDataSource.getInstance(),
                ZonesLocalDataSource.getInstance(context));
    }


    public static BaseSchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }

    public static CamerasRepository provideCamerasRepository(@NonNull Context applicationContext) {
        checkNotNull(applicationContext);
        return CamerasRepository.getInstance(CamerasRemoteDataSource.getInstance(), CamerasLocalDataSource.getInstance(applicationContext));
    }

    public static UserRepository provideUsersDataSource(@NonNull Context applicationContext) {
        checkNotNull(applicationContext);
        return UserRepository.getInstance(UserRemoteDataSource.getInstance(), new UserLocalDataSource());
    }



    public static CameraTreeRepository provideCameraTreeRepository(@NonNull Context context) {
        checkNotNull(context);
        return CameraTreeRepository.getInstance(provideZonesRepository(context), provideCamerasRepository(context));
    }
}
