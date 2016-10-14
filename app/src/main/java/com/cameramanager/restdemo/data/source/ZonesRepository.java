package com.cameramanager.restdemo.data.source;

import android.support.annotation.NonNull;

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
}
