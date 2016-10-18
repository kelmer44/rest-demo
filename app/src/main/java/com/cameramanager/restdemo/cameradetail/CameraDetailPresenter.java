package com.cameramanager.restdemo.cameradetail;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraStream;
import com.cameramanager.restdemo.data.model.capabilities.CameraCapabilities;
import com.cameramanager.restdemo.data.source.CamerasRepository;
import com.cameramanager.restdemo.util.schedulers.BaseSchedulerProvider;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public class CameraDetailPresenter implements CameraDetailContract.Presenter {


    @Nullable
    private final Long mCameraId;
    @NonNull
    private final CamerasRepository mCamerasRepository;
    @NonNull
    private final CameraDetailContract.View mCameraDetailView;


    @NonNull
    private final BaseSchedulerProvider mSchedulerProvider;

    @NonNull
    private final CompositeSubscription mSubscriptions;

    public CameraDetailPresenter(@Nullable final Long cameraId,
                                 @NonNull final CamerasRepository camerasRepository,
                                 @NonNull final CameraDetailContract.View cameraDetailView,
                                 @NonNull final BaseSchedulerProvider schedulerProvider) {
        mCameraId = cameraId;
        mCamerasRepository = checkNotNull(camerasRepository, "Camera Repository cannot be null!");

        mCameraDetailView = checkNotNull(cameraDetailView, "Camera View cannot be null!");
        mSchedulerProvider = checkNotNull(schedulerProvider, "Scheduler Provider cannot be null!");

        mSubscriptions = new CompositeSubscription();
        mCameraDetailView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        openCamera();
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
        mCameraDetailView.stop();
    }

    private void openCamera() {
        if (null == mCameraId || mCameraId <= 0) {
            mCameraDetailView.showMissingCamera();
            return;
        }

        mCameraDetailView.setLoadingIndicator(true);
        Subscription subscription = mCamerasRepository
                .getCameraCapabilities(mCameraId)
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<CameraCapabilities>() {
                    @Override
                    public void onCompleted() {
                        mCameraDetailView.setLoadingIndicator(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CameraCapabilities camera) {
                        showCamera(camera);
                    }


                });

        mSubscriptions.add(subscription);

        mCameraDetailView.setVideoLoadingIndicator(true);
        Subscription streamSubscription = mCamerasRepository
                .getCameraStreams(mCameraId)
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<CameraStream>() {
                    @Override
                    public void onCompleted() {
                        mCameraDetailView.setVideoLoadingIndicator(false);
                    }

                    @Override
                    public void onError(final Throwable e) {

                    }

                    @Override
                    public void onNext(final CameraStream cameraStream) {
                        mCameraDetailView.loadVideo(cameraStream);
                        mCameraDetailView.play();
                    }
                });
    }

    private void showCamera(@NonNull final CameraCapabilities camera) {
        String title = camera.getName();
        mCameraDetailView.showName(title);
        mCameraDetailView.showScreencap(camera.getCameraId());
    }

}
