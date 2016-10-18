package com.cameramanager.restdemo.cameralist;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraTree;
import com.cameramanager.restdemo.data.source.CameraTreeRepository;
import com.cameramanager.restdemo.data.source.CamerasRepository;
import com.cameramanager.restdemo.util.schedulers.BaseSchedulerProvider;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public class CameraListPresenter implements CameraListContract.Presenter {

    @NonNull
    private final CameraTreeRepository mCamerasRepository;

    @NonNull
    private final CameraListContract.View mCamerasView;
    //RX Java stuff
    @NonNull
    private final BaseSchedulerProvider mSchedulerProvider;
    private boolean mFirstLoad = true;
    @NonNull
    private CompositeSubscription mSubscriptions;


    CameraListPresenter(@NonNull CameraTreeRepository cameraTreeRepository,
                        @NonNull CameraListContract.View camerasView,
                        @NonNull BaseSchedulerProvider schedulerProvider) {
        mCamerasRepository = checkNotNull(cameraTreeRepository, "CameraTreeRepository cannot be null");
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

    private void loadCameras(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mCamerasView.setLoadingIndicator(true);
        }
        if (forceUpdate) {
            mCamerasRepository.refresh();
        }

        mSubscriptions.clear();

        final Subscription subscribe = mCamerasRepository
                .getCameraTree()
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<CameraTree>() {
                    @Override
                    public void onCompleted() {
                        mCamerasView.setLoadingIndicator(false);
                    }

                    @Override
                    public void onError(final Throwable e) {
                        mCamerasView.showLoadingCamerasError();
                    }

                    @Override
                    public void onNext(final CameraTree cameraTree) {
                            processCameras(cameraTree);
                    }
                });
        mSubscriptions.add(subscribe);
    }

    private void processCameras(final CameraTree cameras) {
        if (cameras.isEmpty()) {
            processEmptyCameras();
        } else {
            mCamerasView.showCameras(cameras);
        }
    }

    private void processEmptyCameras() {
        mCamerasView.showNoCameras();
    }

    @Override
    public void openCameraDetails(@NonNull Camera requestedCamera) {
        checkNotNull(requestedCamera, "Camera cannot be null!");
        mCamerasView.showCameraDetails(requestedCamera.getCameraId());
    }

    @Override
    public void loadCameras(final boolean forceUpdate) {
        // Simplification for sample: a network reload will be forced on first load.
        loadCameras(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }
}
