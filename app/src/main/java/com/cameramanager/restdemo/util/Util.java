package com.cameramanager.restdemo.util;

import android.support.annotation.Nullable;

/**
 * Created by Gabriel Sanmartín on 10/14/2016.
 */

public class Util {

    public static <T> T checkNotNull(T reference) {
        if(reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }

    public static <T> T checkNotNull(T reference, @Nullable Object errorMessage) {
        if(reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        } else {
            return reference;
        }
    }



}
