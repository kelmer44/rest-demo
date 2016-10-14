package com.cameramanager.restdemo.zones;

import android.support.annotation.NonNull;

import com.cameramanager.restdemo.data.source.Zone;
import com.cameramanager.restdemo.data.source.ZonesRepository;
import com.cameramanager.restdemo.util.schedulers.BaseSchedulerProvider;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

import static com.cameramanager.restdemo.util.Util.checkNotNull;


/**
 * Listens to user actions from the UI ({@link ZonesFragment}), retrieves the data and updates the
 * UI as required.
 * <p>
 * Created by Gabriel Sanmartín on 10/13/2016.
 */
final class ZonesPresenter implements ZonesContract.Presenter {
    @NonNull
    private final ZonesRepository mZonesRepository;

    @NonNull
    private final ZonesContract.View mZonesView;

    @NonNull
    private final BaseSchedulerProvider mSchedulerProvider;

    private boolean mFirstLoad = true;

    @NonNull
    private CompositeSubscription mSubscriptions;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */
    ZonesPresenter(@NonNull ZonesRepository zonesRepository,
                   @NonNull ZonesContract.View zonesView,
                   @NonNull BaseSchedulerProvider schedulerProvider) {
        mZonesRepository = checkNotNull(zonesRepository, "ZonesRepository cannot be null");
        mZonesView = checkNotNull(zonesView, "ZonesView cannot be null");

        mSchedulerProvider = checkNotNull(schedulerProvider, "SchedulerProvider cannot be null");

        mSubscriptions = new CompositeSubscription();
        mZonesView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        loadZones(false);
    }

    public void unsubscribe() { mSubscriptions.clear(); }

    /**
     * @param forceUpdate   Pass in true to refresh the data in the {@link com.cameramanager.restdemo.data.source.ZonesDataSource}
     * @param showLoadingUI Pass in true to display a loading icon in the UI
     */
    private void loadZones(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mZonesView.setLoadingIndicator(true);
        }
        if (forceUpdate) {
            mZonesRepository.refreshZones();
        }

        mSubscriptions.clear();

        Subscription subscription = mZonesRepository
                .getZones()
                .flatMap(new Func1<List<Zone>, Observable<Zone>>() {
                        @Override
                        public Observable<Zone> call(final List<Zone> zones) {
                            return Observable.from(zones);
                        }
                    })
//                .filter()
                .toList()
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<List<Zone>>() {
                    @Override
                    public void onCompleted() {
                        mZonesView.setLoadingIndicator(false);
                    }

                    @Override
                    public void onError(final Throwable e) {
                        mZonesView.showLoadingZonesError();
                    }

                    @Override
                    public void onNext(final List<Zone> zones) {
                        processZones(zones);
                    }
                });
        mSubscriptions.add(subscription);
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
        loadZones(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    private void processZones(final List<Zone> zones) {
        if (zones.isEmpty()) {
            processEmptyZones();
        } else {
            //Show list of zones
            mZonesView.showZones(zones);
        }
    }

    private void processEmptyZones() {
        mZonesView.showNoZones();
    }
}
