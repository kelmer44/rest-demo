package com.cameramanager.restdemo.cameralist;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.model.Camera;
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

        mSubscriptions.clear();

        final Subscription subscribe = mCamerasRepository
                .getCameras()
                .flatMap(new Func1<List<Camera>, Observable<Camera>>() {
                    @Override
                    public Observable<Camera> call(final List<Camera> cameras) {
                        return Observable.from(cameras);
                    }
                })
                .toList()
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<List<Camera>>() {
                    @Override
                    public void onCompleted() {
                        mCamerasView.setLoadingIndicator(false);
                    }

                    @Override
                    public void onError(final Throwable e) {
                        mCamerasView.showLoadingCamerasError();
                    }

                    @Override
                    public void onNext(final List<Camera> cameras) {
                        processCameras(cameras);
                    }
                });
        mSubscriptions.add(subscribe);
    }

    private void processCameras(final List<Camera> cameras) {
        if(cameras.isEmpty()){
            processEmptyCameras();
        } else {
            mCamerasView.showCameras(cameras);
        }
    }

    private void processEmptyCameras() {
        mCamerasView.showNoCameras();
    }


    @Override
    public void openCameraDetails() {

    }
}
