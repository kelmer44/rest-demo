package com.cameramanager.restdemo.cameralist;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.source.CamerasRepository;
import com.cameramanager.restdemo.util.schedulers.BaseSchedulerProvider;

import rx.subscriptions.CompositeSubscription;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public class CameraListPresenter implements CameraListContract.Presenter {

    @NonNull
    private final CamerasRepository mCamerasRepository;

    @NonNull
    private final CameraListContract.View mCamerasView;


    private boolean mFirstLoad = true;

    //RX Java stuff
    @NonNull
    private final BaseSchedulerProvider mSchedulerProvider;

    @NonNull
    private CompositeSubscription mSubscriptions;



    CameraListPresenter(@NonNull CamerasRepository camerasRepository,
                        @NonNull CameraListContract.View camerasView,
                        @NonNull BaseSchedulerProvider schedulerProvider) {
        mCamerasRepository = checkNotNull(camerasRepository, "CamerasRepository cannot be null");
        mCamerasView = checkNotNull(camerasView, "CamerasView cannot be null");
        mSchedulerProvider = checkNotNull(schedulerProvider, "SchedulerProvider cannot be null");

        mSubscriptions = new CompositeSubscription();
        mCamerasView.setPresenter(this);

    }


    @Override
    public void subscribe() {
        loadCameras(false);
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }

    @Override
    public void loadCameras(final boolean forceUpdate) {
        // Simplification for sample: a network reload will be forced on first load.
        loadCameras(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }



    private void loadCameras(boolean forceUpdate, final boolean showLoadingUI) {
        if(showLoadingUI){
            mCamerasView.setLoadingIndicator(true);
        }
        if (forceUpdate) {
            mCamerasRepository.refreshCameras();
        }
    }



    @Override
    public void openCameraDetails() {

    }
}
