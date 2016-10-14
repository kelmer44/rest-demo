package com.cameramanager.restdemo.zones;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.source.ZonesRepository;


/**
 * Listens to user actions from the UI ({@link ZonesFragment}), retrieves the data and updates the
 * UI as required.
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
    ZonesPresenter(@NonNull ZonesRepository zonesRepository, @NonNull ZonesContract.View zonesView) {
        mZonesRepository = zonesRepository;
        mZonesView = zonesView;
    }

    /**
     * Method injection is used here to safely reference {@code this} after the object is created.
     * For more information, see Java Concurrency in Practice.
     */
    void setupListeners() {
        mZonesView.setPresenter(this);
    }

}
