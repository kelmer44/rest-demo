package com.cameramanager.restdemo.zones;

import com.cameramanager.restdemo.data.source.ZonesRepository;

import javax.inject.Inject;

/**
 * Listens to user actions from the UI ({@link ZonesFragment}), retrieves the data and updates the
 * UI as required.
 * <p />
 * By marking the constructor with {@code @Inject}, Dagger injects the dependencies required to
 * create an instance of the TasksPresenter (if it fails, it emits a compiler error).  It uses
 * {@link ZonesPresenterModule} to do so.
 *
 * Created by Gabriel Sanmartín on 10/13/2016.
 */

final class ZonesPresenter implements ZonesContract.Presenter{

    private final ZonesRepository mZonesRepository;
    private final ZonesContract.View mZonesView;


    @Override
    public void start() {

    }

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */
    @Inject
    ZonesPresenter(ZonesRepository zonesRepository, ZonesContract.View zonesView) {
        mZonesRepository = zonesRepository;
        mZonesView = zonesView;
    }

    /**
     * Method injection is used here to safely reference {@code this} after the object is created.
     * For more information, see Java Concurrency in Practice.
     */
    @Inject
    void setupListeners() {
        mZonesView.setPresenter(this);
    }

}
