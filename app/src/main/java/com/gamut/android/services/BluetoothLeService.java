/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gamut.android.services;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Binder;
import android.util.Log;

import com.gamut.android.events.BluetoothGattEvent;
import com.gamut.android.util.GattAttributes;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.UUID;

import de.greenrobot.event.EventBus;

/**
 * Service for managing connection and data communication with a GATT server hosted on a
 * given Bluetooth LE device.
 */
public class BluetoothLeService {
    private final static String TAG = BluetoothLeService.class.getSimpleName();

    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;
    private ArrayList<BluetoothGatt> mBluetoothGatts;
    private ArrayList<GattWriteCommand> mGattWriteQueue;
    private boolean isExecutingCommand = false;

    private Context mContext;

    public final static String ACTION_GATT_CONNECTED =
            "com.example.bluetooth.le.ACTION_GATT_CONNECTED";
    public final static String ACTION_GATT_CONNECTING =
            "com.example.bluetooth.le.ACTION_GATT_CONNECTING";
    public final static String ACTION_GATT_DISCONNECTED =
            "com.example.bluetooth.le.ACTION_GATT_DISCONNECTED";
    public final static String ACTION_GATT_DISCONNECTING =
            "com.example.bluetooth.le.ACTION_GATT_DISCONNECTING";
    public final static String ACTION_GATT_SERVICES_DISCOVERED =
            "com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED";
    public final static String ACTION_DATA_AVAILABLE =
            "com.example.bluetooth.le.ACTION_DATA_AVAILABLE";
    public final static String ACTION_GATT_SERVICES_ERROR =
            "com.ifit.android.app.bluetooth.le.GATT_SERVICES_ERROR";


    private static BluetoothLeService mBluetoothLeService;

    public BluetoothLeService(Application context) {
        mContext = context;
        initialize();
    }

    public static void createInstance(Application context) {
        if (mBluetoothLeService == null) {
            mBluetoothLeService = new BluetoothLeService(context);
        }
    }

    public static BluetoothLeService getInstance() {
        return mBluetoothLeService;
    }

    // Implements callback methods for GATT events that the app cares about.  For example,
    // connection change and services discovered.
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            String intentAction;
            if (status == BluetoothGatt.GATT_SUCCESS) {
                if (newState == BluetoothProfile.STATE_CONNECTED) {
                    intentAction = ACTION_GATT_CONNECTED;
                    broadcastUpdate(gatt.getDevice().getAddress(), intentAction);
                    Log.i(TAG, "Connected to GATT server.");
                    // Attempts to discover services after successful connection.
                    Log.i(TAG, "Attempting to start service discovery:" +
                            gatt.discoverServices());

                } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                    intentAction = ACTION_GATT_DISCONNECTED;
                    Log.i(TAG, "Disconnected from GATT server.");
                    close(gatt.getDevice().getAddress());
                    broadcastUpdate(gatt.getDevice().getAddress(), intentAction);
                }
            } else {

                if (gatt.getDevice() != null) {

                    disconnect(gatt.getDevice().getAddress());
                    close(gatt.getDevice().getAddress());

                    Log.i(TAG, "Gatt server error");
                    broadcastUpdate(gatt.getDevice().getAddress(), ACTION_GATT_SERVICES_ERROR);
                }
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                broadcastUpdate(gatt.getDevice().getAddress(), ACTION_GATT_SERVICES_DISCOVERED);
            } else {
                Log.w(TAG, "onServicesDiscovered received: " + status);
            }
        }

        @Override
        public void onCharacteristicRead(BluetoothGatt gatt,
                                         BluetoothGattCharacteristic characteristic,
                                         int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                broadcastUpdate(gatt.getDevice().getAddress(), ACTION_DATA_AVAILABLE, characteristic);
                Log.d("GATT Characteristic Received", String.valueOf(characteristic.getValue()));
            }
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt,
                                            BluetoothGattCharacteristic characteristic) {
            broadcastUpdate(gatt.getDevice().getAddress(), ACTION_DATA_AVAILABLE, characteristic);
            Log.d("GATT Characteristic Received", String.valueOf(characteristic.getValue()));
        }

        @Override
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            super.onCharacteristicWrite(gatt, characteristic, status);
            //mGattWriteQueue.remove(0);
            //executeNextWrite();
        }
    };

    private void broadcastUpdate(final String address, final String action) {
        EventBus.getDefault().post(new BluetoothGattEvent(address, action, null));
    }

    private void broadcastUpdate(final String address, final String action,
                                 final BluetoothGattCharacteristic characteristic) {

        String val = "";

        // For all other profiles, writes the data formatted in HEX.
        final byte[] data = characteristic.getValue();
        if (data != null && data.length > 0) {
            final StringBuilder stringBuilder = new StringBuilder(data.length);
            for(byte byteChar : data)
                stringBuilder.append(String.format("%02X ", byteChar));
            val = new String(data) + "\n" + stringBuilder.toString();
        }

        EventBus.getDefault().post(new BluetoothGattEvent(address, action, val));
    }

    public class LocalBinder extends Binder {
        BluetoothLeService getService() {
            return BluetoothLeService.this;
        }
    }

    /**
     * Initializes a reference to the local Bluetooth adapter.
     *
     * @return Return true if the initialization is successful.
     */
    public boolean initialize() {

        mBluetoothGatts = new ArrayList<BluetoothGatt>();
        mGattWriteQueue = new ArrayList<GattWriteCommand>();

        // For API level 18 and above, get a reference to BluetoothAdapter through
        // BluetoothManager.
        if (mBluetoothManager == null) {
            mBluetoothManager = (BluetoothManager) mContext.getSystemService(Context.BLUETOOTH_SERVICE);
            if (mBluetoothManager == null) {
                Log.e(TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }

        mBluetoothAdapter = mBluetoothManager.getAdapter();
        if (mBluetoothAdapter == null) {
            Log.e(TAG, "Unable to obtain a BluetoothAdapter.");
            return false;
        }

        return true;
    }

    /**
     * Connects to the GATT server hosted on the Bluetooth LE device.
     *
     * @param address The device address of the destination device.
     *
     * @return Return true if the connection is initiated successfully. The connection result
     *         is reported asynchronously through the
     *         {@code BluetoothGattCallback#onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int)}
     *         callback.
     */
    public boolean connect(final String address) {
        if (mBluetoothAdapter == null || address == null) {
            Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }

        // Previously connected device.  Try to reconnect.
        final BluetoothGatt gatt = getBluetoothGatt(address);
        if (gatt != null) {
            Log.d(TAG, "Trying to use an existing mBluetoothGatt for connection.");
            return (gatt.getDevice() != null && gatt.connect());
        }

        final BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        if (device == null) {
            Log.w(TAG, "Device not found.  Unable to connect.");
            return false;
        }
        // We want to directly connect to the device, so we are setting the autoConnect
        // parameter to false.
        final BluetoothGatt bluetoothGatt = device.connectGatt(mContext, false, mGattCallback);
        EventBus.getDefault().post(new BluetoothGattEvent(device.getAddress(), ACTION_GATT_CONNECTING, null));
        if (bluetoothGatt != null) {
            mBluetoothGatts.add(bluetoothGatt);
            Log.d(TAG, "Trying to create a new connection.");
            return true;
        }

        Log.w(TAG, "Something went wrong.  Unable to connect.");
        return false;
    }

    /**
     * Disconnects an existing connection or cancel a pending connection. The disconnection result
     * is reported asynchronously through the
     * {@code BluetoothGattCallback#onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int)}
     * callback.
     */
    public void disconnect() {

        if (mBluetoothGatts == null) {
            Log.w(TAG, "No gatts");
            return;
        }

        for (BluetoothGatt gatt : mBluetoothGatts) {
            if (gatt.getDevice() != null) {
                gatt.disconnect();
                break;
            }
        }

        close();
    }

    public void disconnect(String address) {

        if (mBluetoothAdapter == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }

        if (mBluetoothGatts == null || address == null || address.length() == 0) {
            Log.w(TAG, "No devices or gatts");
            return;
        }

        BluetoothGatt bluetoothGatt = null;
        for (BluetoothGatt gatt : mBluetoothGatts) {
            if (gatt.getDevice() != null && gatt.getDevice().getAddress().equals(address)) {
                bluetoothGatt = gatt;
                break;
            }
        }

        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
            //close(bluetoothGatt.getDevice().getAddress());

            broadcastUpdate(bluetoothGatt.getDevice().getAddress(), ACTION_GATT_DISCONNECTED);
        }
    }

    /**
     * After using a given BLE device, the app must call this method to ensure resources are
     * released properly.
     */
    public void close() {

        if (mBluetoothGatts == null) {
            return;
        }

        for (BluetoothGatt gatt : mBluetoothGatts) {
            if (gatt.getDevice() != null) {
                gatt.close();
            }
        }

        mBluetoothGatts.clear();
    }

    public void close(String address) {

        if (mBluetoothAdapter == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }

        if (mBluetoothGatts == null || address == null || address.length() == 0) {
            Log.w(TAG, "No devices or gatts");
            return;
        }

        try {
            final ArrayList<BluetoothGatt> deletes = new ArrayList<BluetoothGatt>();
            for (BluetoothGatt gatt : mBluetoothGatts) {
                if (gatt.getDevice() != null && gatt.getDevice().getAddress().equals(address)) {
                    gatt.close();
                    deletes.add(gatt);
                }
            }

            if (deletes.size() > 0) {
                for (BluetoothGatt delete : deletes) {
                    if (mBluetoothGatts.contains(delete)) {
                        mBluetoothGatts.remove(delete);
                    }
                }
            }
            deletes.clear();
        } catch (ConcurrentModificationException cmexp) {
            cmexp.printStackTrace();
        }
    }

    public void stop() {
        disconnect();
        close();
    }

    /**
     * Request a read on a given {@code BluetoothGattCharacteristic}. The read result is reported
     * asynchronously through the {@code BluetoothGattCallback#onCharacteristicRead(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, int)}
     * callback.
     *
     * @param characteristic The characteristic to read from.
     */
    public void readCharacteristic(String address, BluetoothGattCharacteristic characteristic) {
        if (mBluetoothAdapter == null || mBluetoothGatts == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }

        final BluetoothGatt gatt = getBluetoothGatt(address);

        if (gatt != null) {
            gatt.readCharacteristic(characteristic);
        }
    }

    public BluetoothGattCharacteristic getWriteCharacteristic(String address) {

        if (mBluetoothAdapter == null || mBluetoothGatts == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return null;
        }

        final BluetoothGatt gatt = getBluetoothGatt(address);

        if (gatt != null) {
            final List<BluetoothGattService> services = gatt.getServices();
            for (BluetoothGattService service : services) {
                if (service.getUuid().equals(GattAttributes.BLE_SHIELD_SERVICE)) {
                    return service.getCharacteristic(GattAttributes.BLE_SHIELD_TX);
                }
            }
        }

        return null;

    }

    public BluetoothGattCharacteristic getWriteCharacteristic() {
        return mBluetoothGatts != null && mBluetoothGatts.size() > 0 ?
                getWriteCharacteristic(mBluetoothGatts.get(0).getDevice().getAddress()) :
                null;
    }

    public void writeCharacteristic(String address, BluetoothGattCharacteristic characteristic) {

        if (mBluetoothAdapter == null || mBluetoothGatts == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }

        final BluetoothGatt gatt = getBluetoothGatt(address);

        if (gatt != null) {
            gatt.writeCharacteristic(characteristic);
        }
    }

    public void writeCharacteristic(BluetoothGattCharacteristic characteristic) {

        if (mBluetoothAdapter == null || mBluetoothGatts == null ||
                mBluetoothGatts.size() == 0 || mBluetoothGatts.get(0) == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }

        final BluetoothGatt gatt = mBluetoothGatts.get(0);

        if (gatt != null) {
            gatt.writeCharacteristic(characteristic);
        }
    }

    /**
     * Enables or disables notification on a give characteristic.
     *
     * @param characteristic Characteristic to act on.
     * @param enabled If true, enable notification.  False otherwise.
     */
    public void setCharacteristicNotification(String address, BluetoothGattCharacteristic characteristic,
                                              boolean enabled) {
        setCharacteristicNotification(address, characteristic, null, enabled);
    }

    public void setCharacteristicNotification(String address,
                                              BluetoothGattCharacteristic characteristic,
                                              UUID descriptor,
                                              boolean enabled) {
        if (mBluetoothAdapter == null || mBluetoothGatts == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }

        final BluetoothGatt gatt = getBluetoothGatt(address);

        if (gatt != null) {
            gatt.setCharacteristicNotification(characteristic, enabled);

            // This is specific to Heart Rate Measurement.
            if (descriptor != null) {
                BluetoothGattDescriptor descriptorGatt = characteristic.getDescriptor(descriptor);

                if (descriptorGatt != null) {
                    descriptorGatt.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                    gatt.writeDescriptor(descriptorGatt);
                }
            }
        }
    }

    /**
     * Retrieves a list of supported GATT services on the connected device. This should be
     * invoked only after {@code BluetoothGatt#discoverServices()} completes successfully.
     *
     * @return A {@code List} of supported services.
     */
    public List<BluetoothGattService> getSupportedGattServices(String address) {

        final BluetoothGatt gatt = getBluetoothGatt(address);

        if (gatt != null) {
            return gatt.getServices();
        }

        return null;
    }

    public boolean isDeviceConnected(String address) {

        for (BluetoothGatt gatt : mBluetoothGatts) {
            if (gatt.getDevice() != null && gatt.getDevice().getAddress().equals(address)) {
                final int state = mBluetoothManager.getConnectionState(gatt.getDevice(), BluetoothProfile.GATT);
                if (state == BluetoothProfile.STATE_CONNECTED) {
                    return true;
                }
            }
        }

        return false;
    }

    public List<BluetoothDevice> getConnectedDevices() {

        final ArrayList<BluetoothDevice> devices = new ArrayList<BluetoothDevice>();

        for (BluetoothGatt gatt : mBluetoothGatts) {
            if (gatt.getDevice() != null) {
                final int state = mBluetoothManager.getConnectionState(gatt.getDevice(), BluetoothProfile.GATT);
                if (state == BluetoothProfile.STATE_CONNECTED) {
                    devices.add(gatt.getDevice());
                }
            }
        }

        for (BluetoothDevice device : mBluetoothManager.getConnectedDevices(BluetoothProfile.GATT)) {
            final int state = mBluetoothManager.getConnectionState(device, BluetoothProfile.GATT);
            if (state == BluetoothProfile.STATE_CONNECTED) {
                if (!devices.contains(device)) {
                    devices.add(device);
                }
            }
        }

        return devices;
    }

    private void executeNextWrite() {
        if (mGattWriteQueue.size() > 0) {
            final GattWriteCommand command = mGattWriteQueue.get(0);
            if (command != null) {
                isExecutingCommand = true;
                command.getGatt().writeCharacteristic(command.getCharacteristic());
            } else {
                mGattWriteQueue.remove(0);
                executeNextWrite();
            }
        } else {
            isExecutingCommand = false;
        }
    }

    private BluetoothGatt getBluetoothGatt(BluetoothDevice device) {

        if (device == null || mBluetoothGatts == null || mBluetoothGatts.size() == 0) {
            return null;
        }

        return getBluetoothGatt(device.getAddress());
    }

    private BluetoothGatt getBluetoothGatt(String address) {

        if (address == null || address.length() == 0) {
            return null;
        }

        for (BluetoothGatt gatt : mBluetoothGatts) {
            if (gatt.getDevice() != null && gatt.getDevice().getAddress().equals(address)) {
                return gatt;
            }
        }

        return null;
    }

    public static class GattWriteCommand {

        private BluetoothGattCharacteristic mCharacteristic;
        private BluetoothGatt mGatt;

        public GattWriteCommand(BluetoothGattCharacteristic characteristic, BluetoothGatt gatt) {
            mCharacteristic = characteristic;
            mGatt = gatt;
        }

        public BluetoothGattCharacteristic getCharacteristic() {
            return mCharacteristic;
        }

        public BluetoothGatt getGatt() {
            return mGatt;
        }

    }
}