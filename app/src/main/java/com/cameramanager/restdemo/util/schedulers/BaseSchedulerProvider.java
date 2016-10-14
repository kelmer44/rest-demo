package com.cameramanager.restdemo.util.schedulers;

import android.support.annotation.NonNull;

import rx.Scheduler;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
