package com.gamut.android;

import android.app.Application;

import com.gamut.android.services.BluetoothLeService;

/**
 * Created by user on 3/3/14.
 */
public class GamutApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BluetoothLeService.createInstance(this);
    }
}
