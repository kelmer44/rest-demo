package com.cameramanager.restdemo.cameralist;

import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraTree;
import com.cameramanager.restdemo.data.model.User;
import com.cameramanager.restdemo.data.model.Zone;
import com.cameramanager.restdemo.data.source.CameraTreeRepository;
import com.cameramanager.restdemo.data.source.CamerasRepository;
import com.cameramanager.restdemo.data.source.UserRepository;
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

public  class CameraListPresenter implements CameraListContract.Presenter {

    @NonNull
    private final CameraTreeRepository mCamerasRepository;

    @NonNull
    private final UserRepository mUserRepository;
    @NonNull
    private final CameraListContract.View mCamerasView;


    //RX Java stuff
    @NonNull
    private final BaseSchedulerProvider mSchedulerProvider;
    @NonNull
    private CompositeSubscription mSubscriptions;

    private boolean mFirstLoad = true;
    private int mCurrentFiltering = 0;


    CameraListPresenter(@NonNull CameraTreeRepository cameraTreeRepository,
                        @NonNull UserRepository userRepository,
                        @NonNull CameraListContract.View camerasView,
                        @NonNull BaseSchedulerProvider schedulerProvider) {
        mCamerasRepository = checkNotNull(cameraTreeRepository, "CameraTreeRepository cannot be null");
        mUserRepository = userRepository;
        mCamerasView = checkNotNull(camerasView, "CamerasView cannot be null");
        mSchedulerProvider = checkNotNull(schedulerProvider, "SchedulerProvider cannot be null");

        mSubscriptions = new CompositeSubscription();
        mCamerasView.setPresenter(this);

    }


    @Override
    public void subscribe() {
        loadCameras(false);
        loadUser();
    }

    private void loadUser() {
        final Subscription userSubscription = mUserRepository.getSelf()
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(final Throwable e) {
                        mCamerasView.showLoadingUserError();
                    }

                    @Override
                    public void onNext(final User user) {
                        processUserName(user);
                    }
                });
        mSubscriptions.add(userSubscription);
    }

    private void processUserName(final User user) {
        if (user != null) {
            mCamerasView.showUser(user);
        }
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }


    @Override
    public void loadCameras(final boolean forceUpdate) {
        // Simplification for sample: a network reload will be forced on first load.
        loadCameras(forceUpdate || mFirstLoad, true);
    }



    /**
     * @param forceUpdate   Pass in true to refresh the data
     * @param showLoadingUI Pass in true to display a loading icon in the UI
     */
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
                            if(mFirstLoad) {
                                final Zone zone = cameraTree.getZones().get(0);
                                mCurrentFiltering = zone.getZoneId().intValue();
                                mFirstLoad = false;
                            }
                            processCameras(cameraTree);
                            processZoneList(cameraTree);
                    }
                });
        mSubscriptions.add(subscribe);
    }

    private void processZoneList(final CameraTree cameraTree) {
        if(cameraTree.isEmpty()){
            return;
        }
        mCamerasView.loadFilter(cameraTree.getZones());
    }

    private void processCameras(final CameraTree cameras) {
        if (cameras.isEmpty()) {
            processEmptyCameras();
        } else {
            mCamerasView.showCameras(cameras.getCamerasByZone(new Long(mCurrentFiltering)));
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
    public void setFiltering(@NonNull final int id) {
        mCurrentFiltering = id;
    }

    @Override
    public int getFiltering() {
        return 0;
    }

}
