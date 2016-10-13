package com.cameramanager.restdemo.data.source;

import com.cameramanager.restdemo.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * This is a Dagger component. Refer to {@link com.cameramanager.restdemo.RestDemoApplication} for the list of Dagger components
 * used in this application.
 * <P>
 * Even though Dagger allows annotating a {@link Component @Component} as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in {@link
 * com.cameramanager.restdemo.RestDemoApplication}.
 */
@Singleton
@Component(modules = {ZonesRepositoryModule.class, ApplicationModule.class})
public interface ZonesRepositoryComponent {

    ZonesRepository getZonesRepository();
}
