package com.cameramanager.restdemo;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */
@Module
public class ApplicationModule {

    private final Context mContext;

    ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}
