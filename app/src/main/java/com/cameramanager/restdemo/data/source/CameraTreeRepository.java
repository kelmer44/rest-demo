package com.cameramanager.restdemo.data.source;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraTree;
import com.cameramanager.restdemo.data.model.Zone;

import java.util.List;

import rx.Observable;
import rx.functions.Func2;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/18/2016.
 */

public class CameraTreeRepository {

    private static CameraTreeRepository INSTANCE = null;

    @NonNull
    private final ZonesRepository mZonesRepository;
    @NonNull
    private final CamerasRepository mCamerasRepository;

    private CameraTreeRepository(@NonNull ZonesRepository zonesRepository, @NonNull CamerasRepository camerasRepository) {
        mZonesRepository = checkNotNull(zonesRepository);
        mCamerasRepository = checkNotNull(camerasRepository);
    }


    public static CameraTreeRepository getInstance(ZonesRepository zonesRepository, CamerasRepository camerasRepository) {
        if (INSTANCE == null) {
            INSTANCE = new CameraTreeRepository(zonesRepository, camerasRepository);
        }
        return INSTANCE;
    }


    public Observable<CameraTree> getCameraTree() {
        Observable<CameraTree> combined = Observable.zip(
                mZonesRepository.getZones(),
                mCamerasRepository.getCameras(),
                new Func2<List<Zone>, List<Camera>, CameraTree>() {
            @Override
            public CameraTree call(List<Zone> zones, List<Camera> cameras) {
                return new CameraTree(zones, cameras);
            }
        });
        return combined;
    }

    public void refresh(){
        mCamerasRepository.refreshCameras();
        mZonesRepository.refreshZones();
    }
}
