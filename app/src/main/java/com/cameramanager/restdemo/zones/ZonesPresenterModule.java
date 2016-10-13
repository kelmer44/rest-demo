package com.cameramanager.restdemo.zones;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */
@Module
public class ZonesPresenterModule {

    private final ZonesContract.View mView;

    public ZonesPresenterModule(ZonesContract.View view){
        mView = view;
    }

    @Provides
    ZonesContract.View provideZonesContractView() {
        return mView;
    }


}
