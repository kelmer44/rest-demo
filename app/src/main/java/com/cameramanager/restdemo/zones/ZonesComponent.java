package com.cameramanager.restdemo.zones;

import com.cameramanager.restdemo.data.source.ZonesRepositoryComponent;
import com.cameramanager.restdemo.util.FragmentScoped;

import dagger.Component;

/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */

@FragmentScoped
@Component(dependencies = ZonesRepositoryComponent.class, modules = ZonesPresenterModule.class)
public interface ZonesComponent {

    void inject(ZonesActivity activity);
}
