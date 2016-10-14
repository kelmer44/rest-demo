package com.cameramanager.restdemo.data.source;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

import static com.cameramanager.restdemo.util.Util.checkNotNull;


/**
 * Concrete implementation to load tasks from the data sources into a cache.
 * <p>
 * For simplicity, this implements a dumb synchronisation between locally persisted data and data
 * obtained from the server, by using the remote data source only if the local database doesn't
 * exist or is empty.
 */
public class ZonesRepository {

    private static ZonesRepository INSTANCE = null;

    private final ZonesDataSource mZonesRemoteDataSource;
    private final ZonesDataSource mZonesLocalDataSource;


    private Map<Long, Zone> mCachedZones;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    private boolean mCacheIsDirty = false;

    // Prevent direct instantiation.
    private ZonesRepository(@NonNull ZonesDataSource zonesRemoteDataSource, @NonNull ZonesDataSource zonesLocalDataSource){
        mZonesRemoteDataSource = checkNotNull(zonesRemoteDataSource);
        mZonesLocalDataSource = checkNotNull(zonesLocalDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param tasksRemoteDataSource the backend data source
     * @param tasksLocalDataSource  the device storage data source
     * @return the {@link ZonesRepository} instance
     */
    public static ZonesRepository getInstance(ZonesDataSource tasksRemoteDataSource,
                                              ZonesDataSource tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new ZonesRepository(tasksRemoteDataSource, tasksLocalDataSource);
        }
        return INSTANCE;
    }

    public void refreshZones() {
        mCacheIsDirty = true;
    }

    public Observable<List<Zone>> getZones() {
        //Respond immediately with cache if available and not dirty
        if (mCachedZones != null && !mCacheIsDirty) {
            return Observable.from(mCachedZones.values()).toList();
        } else if (mCachedZones == null) {
            mCachedZones = new LinkedHashMap<>();
        }

        Observable<List<Zone>> remoteTasks = getAndSaveRemoteTasks();

        if(mCacheIsDirty){
            //If the cache is dirty we need to fetch new data from the network
            return remoteTasks;
        }
        else {
            //Get from local copy
            return null;
        }
    }

    private Observable<List<Zone>> getAndSaveRemoteTasks() {
        return mZonesRemoteDataSource
                .getZones()
                .flatMap(new Func1<List<Zone>, Observable<List<Zone>>>() {
                    @Override
                    public Observable<List<Zone>> call(final List<Zone> zones) {
                        return Observable.from(zones).doOnNext(new Action1<Zone>() {
                            @Override
                            public void call(final Zone zone) {
                                //mZonesLocalDataSource.saveZone(zone);
                                mCachedZones.put(zone.getZoneId(), zone);
                            }
                        }).toList();
                    }
                }).doOnCompleted(new Action0() {
                    @Override
                    public void call() {
                        mCacheIsDirty = false;
                    }
                });
    }

    private Observable<List<Zone>> getAndCacheLocalTasks(final List<Zone> zones) {
        //TODO
        return null;
    }

    private void refreshCache(final List<Zone> zones) {
        if(mCachedZones == null) {
            mCachedZones = new LinkedHashMap<>();
        }
        mCachedZones.clear();
        for (final Zone zone : zones) {
            mCachedZones.put(zone.getZoneId(), zone);
        }
        mCacheIsDirty = false;
    }
}
