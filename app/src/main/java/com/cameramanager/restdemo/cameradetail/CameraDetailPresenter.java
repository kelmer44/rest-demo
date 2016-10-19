package com.cameramanager.restdemo.cameradetail;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cameramanager.restdemo.data.model.Camera;
import com.cameramanager.restdemo.data.model.CameraStream;
import com.cameramanager.restdemo.data.model.capabilities.CameraCapabilities;
import com.cameramanager.restdemo.data.source.CamerasRepository;
import com.cameramanager.restdemo.util.schedulers.BaseSchedulerProvider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.cameramanager.restdemo.util.Util.checkNotNull;

/**
 * Created by Gabriel Sanmartín on 10/17/2016.
 */

public class CameraDetailPresenter implements CameraDetailContract.Presenter {


    private static final String TAG = "CameraDetailPresenter";
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
        processCapabilities(camera);
    }

    private void processCapabilities(final CameraCapabilities camera) {
        List<DataValue> dataValues = new ArrayList<>();
        gatherData(camera, dataValues);
        mCameraDetailView.showCapabilities(dataValues);
    }


    void gatherData(@NonNull Object obj, List<DataValue> data){
        for (final Method method : obj.getClass().getDeclaredMethods()) {
            if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
                try {
                    final Object result = method.invoke(obj, null);
                    if(result == null){
                        continue;
                    }
                    if(isWrapperType(method.getReturnType()) || method.getReturnType().isPrimitive() || method.getReturnType().equals(String.class)){
                        int index = method.getName().indexOf("get");
                        if(index < 0){
                            index = method.getName().indexOf("is");
                        }
                        String fieldName = method.getName().replaceFirst("get", "");
                        fieldName = fieldName.replaceFirst("is", "");
                        final String value = result.toString();
                        data.add(new DataValue(fieldName, value));
                    }
                    else {
                        gatherData(result, data);
                    }
                } catch (IllegalAccessException e) {
                    Log.e(TAG, "gatherData: ", e);
                } catch (InvocationTargetException e) {
                    Log.e(TAG, "gatherData: ", e);
                }
            }
        }
    }



    public static boolean isWrapperType(Class<?> clazz)
    {
        return WRAPPER_TYPES.contains(clazz);
    }

    private static final Set<Class<?>> WRAPPER_TYPES = getWrapperTypes();

    private static Set<Class<?>> getWrapperTypes()
    {
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        return ret;
    }

    class DataValue {
        String field;
        String value;

        public DataValue(String f, String v){
            field = f;
            value = v;
        }
    }


}
