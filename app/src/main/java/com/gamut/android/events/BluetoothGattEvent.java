package com.gamut.android.events;

/**
 * Created by jeremiahstephenson on 2/3/14.
 */
public class BluetoothGattEvent {

    private String mAddress;
    private String mAction;
    private String mData;

    public BluetoothGattEvent(String address, String action, String data) {
        mAddress = address;
        mAction = action;
        mData = data;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getAction() {
        return mAction;
    }

    public String getData() {
        return mData;
    }

}