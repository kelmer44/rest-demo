package com.cameramanager.restdemo.data.source;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.Zone;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public class CamerasRepository {

    private static CamerasRepository INSTANCE = null;

    private final CamerasDataSource mCamerasLocalDataSource;
    private final CamerasDataSource mCamerasRemoteDataSource;


    private Map<Long, Camera> mCachedCameras;

    private boolean mCacheIsDirty = false;


    private CamerasRepository(@NonNull CamerasDataSource remoteDataSource, @NonNull CamerasDataSource camerasLocalDataSource) {
        mCamerasLocalDataSource = checkNotNull(camerasLocalDataSource);
        mCamerasRemoteDataSource = checkNotNull(remoteDataSource);
    }


    public static CamerasRepository getInstance(CamerasDataSource remoteDataSource,
                                                CamerasDataSource localDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new CamerasRepository(remoteDataSource, localDataSource);
        }
        return INSTANCE;
    }

    public void refreshCameras() {
        mCacheIsDirty = true;
    }

    public Observable<List<Camera>> getCameras() {
        if (mCachedCameras != null && !mCacheIsDirty) {
            return Observable.from(mCachedCameras.values()).toList();
        }
        else if (mCachedCameras == null) {
            mCachedCameras = new LinkedHashMap<>();
        }

        final Observable<List<Camera>> remoteCameras = getAndSaveRemoteCameras();

        if(mCacheIsDirty) {
            return remoteCameras;
        }
        else {
            return null;
        }
    }

    private Observable<List<Camera>> getAndSaveRemoteCameras() {
        return mCamerasRemoteDataSource.
                getCameras().
                flatMap(new Func1<List<Camera>, Observable<List<Camera>>>() {
                    @Override
                    public Observable<List<Camera>> call(final List<Camera> cameras) {
                        return Observable.from(cameras).doOnNext(new Action1<Camera>() {
                            @Override
                            public void call(final Camera camera) {
                                mCachedCameras.put(camera.getCameraId(), camera);
                            }
                        }).toList();
                    }
                })
                .doOnCompleted(new Action0() {
                    @Override
                    public void call() {
                        mCacheIsDirty = false;
                    }
                });
    }


    private void refreshCache(final List<Camera> cameras) {
        if(mCachedCameras == null) {
            mCachedCameras = new LinkedHashMap<>();
        }
        mCachedCameras.clear();
        for (final Camera camera : cameras) {
            mCachedCameras.put(camera.getCameraId(), camera);
        }
        mCacheIsDirty = false;
    }

}
