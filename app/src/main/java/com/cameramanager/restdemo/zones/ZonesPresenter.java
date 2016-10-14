package com.cameramanager.restdemo.zones;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.source.Zone;
import com.cameramanager.restdemo.data.source.ZonesDataSource;
import com.cameramanager.restdemo.data.source.ZonesRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * Listens to user actions from the UI ({@link ZonesFragment}), retrieves the data and updates the
 * UI as required.
 *
 * Created by Gabriel Sanmartín on 10/13/2016.
 */
final class ZonesPresenter implements ZonesContract.Presenter{

    private final ZonesRepository mZonesRepository;
    private final ZonesContract.View mZonesView;

    private boolean mFirstLoad = true;

    @Override
    public void start() {
        loadZones(false);
    }

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */
    ZonesPresenter(@NonNull ZonesRepository zonesRepository, @NonNull ZonesContract.View zonesView) {
        mZonesRepository = zonesRepository;
        mZonesView = zonesView;

        mZonesView.setPresenter(this);
    }

    /**
     * Method injection is used here to safely reference {@code this} after the object is created.
     * For more information, see Java Concurrency in Practice.
     */
    void setupListeners() {
        mZonesView.setPresenter(this);
    }

    @Override
    public void addNewZone() {

    }

    @Override
    public void loadZones(final boolean forceUpdate) {
        // Simplification for sample: a network reload will be forced on first load.
        loadTasks(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    /**
     * @param forceUpdate   Pass in true to refresh the data in the {@link com.cameramanager.restdemo.data.source.ZonesDataSource}
     * @param showLoadingUI Pass in true to display a loading icon in the UI
     */
    private void loadTasks(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mZonesView.setLoadingIndicator(true);
        }
        if(forceUpdate) {
            mZonesRepository.refreshTasks();
        }

        mZonesRepository.getZones(new ZonesDataSource.LoadZonesCallback(){

            @Override
            public void onZonesLoaded(final List<Zone> zones) {
                // The view may not be able to handle UI updates anymore
                if (!mZonesView.isActive()) {
                    return;
                }
                if (showLoadingUI) {
                    mZonesView.setLoadingIndicator(false);
                }

                processZones(zones);
            }

            @Override
            public void onDataNotAvailable() {
                // The view may not be able to handle UI updates anymore
                if (!mZonesView.isActive()) {
                    return;
                }
                mZonesView.showLoadingTasksError();
            }
        });
    }

    private void processZones(final List<Zone> zones) {
        if (zones.isEmpty()) {
            processEmptyZones();
        }
        else {
            //Show list of zones
            mZonesView.showZones(zones);
        }
    }

    private void processEmptyZones() {
        mZonesView.showNoZones();
    }
}
