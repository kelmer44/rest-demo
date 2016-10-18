package com.cameramanager.restdemo.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gabriel Sanmartín on 10/18/2016.
 */

public class CameraTree {

    private Map<Zone, List<Camera>> mCameraTree = new HashMap<>();



    public CameraTree(List<Zone> zones, List<Camera> cameras) {
        for (final Zone zone : zones) {
            for (final Camera camera : cameras) {
                if(zone.getZoneId().equals(camera.getZoneId())){
                    addCameraToZone(camera, zone);
                }
            }
        }
    }

    private void addCameraToZone(Camera camera, Zone zone){
        if(camera ==null) {
            return;
        }

        List<Camera> cameras = mCameraTree.get(zone);
        if (cameras == null) {
            cameras = new ArrayList<>();
        }
        cameras.add(camera);

        mCameraTree.put(zone, cameras);
    }


    public List<Zone> getZones() {
        return new ArrayList(mCameraTree.keySet());
    }

    public List<Camera> getCamerasByZone(Long zoneId) {
        for (final Map.Entry<Zone, List<Camera>> zoneListEntry : mCameraTree.entrySet()) {
            if(zoneListEntry.getKey().getZoneId().equals(zoneId)){
                return mCameraTree.get(zoneListEntry.getKey());
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return mCameraTree.isEmpty();
    }
}
