package com.cameramanager.restdemo.data.source;

import java.util.List;

import rx.Observable;

/**
 * Created by Gabriel Sanmartín on 10/13/2016.
 */

public interface ZonesDataSource {

    Observable<List<Zone>> getZones();
}
