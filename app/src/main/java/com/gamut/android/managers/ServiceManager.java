package com.gamut.android.managers;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;

import com.gamut.android.events.ServiceConnectionEvent;
import com.gamut.android.services.BluetoothLeService;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by jeremiahstephenson on 1/30/14.
 */
public class ServiceManager {

    private static ServiceManager serviceManager;

    private BluetoothLeService bluetoothLeService;

    public static ServiceManager getInstance() {

        if (serviceManager == null) {
            serviceManager = new ServiceManager();
        }

        return serviceManager;
    }

    public void startBluetoothService(Context context) {

        if (bluetoothLeService == null) {

            final Intent intent = new Intent(context, BluetoothLeService.class);
            context.startService(intent);

        }

    }

    public void addServiceConnection(BluetoothLeService service) {

        if (bluetoothLeService != null && bluetoothLeService != service) {
            removeServiceConnection();
        }

        bluetoothLeService = service;

        EventBus.getDefault().post(new ServiceConnectionEvent(ServiceConnectionEvent.ServiceConnectionType.CONNECTED));
    }

    public void removeServiceConnection() {

        if (bluetoothLeService != null) {
            bluetoothLeService.stop();
            bluetoothLeService = null;
            EventBus.getDefault().post(new ServiceConnectionEvent(ServiceConnectionEvent.ServiceConnectionType.DISCONNECTED));
        }
    }

    public void connect(String address) {
        if (bluetoothLeService != null) {
            bluetoothLeService.connect(address);
        }
    }

    public void disconnect(String address) {
        if (bluetoothLeService != null) {
            bluetoothLeService.disconnect(address);
        }
    }

    public List<BluetoothGattService> getSupportedGattServices(String address) {
        if (bluetoothLeService != null) {
            return bluetoothLeService.getSupportedGattServices(address);
        }

        return null;
    }

    public void setCharacteristicNotification(String address, BluetoothGattCharacteristic characteristic,
                                              boolean enabled) {
        if (bluetoothLeService != null) {
            bluetoothLeService.setCharacteristicNotification(address, characteristic, enabled);
        }
    }

    public void readCharacteristic(String address, BluetoothGattCharacteristic characteristic) {
        if (bluetoothLeService != null) {
            bluetoothLeService.readCharacteristic(address, characteristic);
        }
    }

    public boolean isDeviceConnected(String address) {
        return bluetoothLeService != null && bluetoothLeService.isDeviceConnected(address);
    }

    public boolean isServiceRunning() {
        return bluetoothLeService != null;
    }

    public List<BluetoothDevice> getConnectedDevices() {
        if (bluetoothLeService != null) {
            return bluetoothLeService.getConnectedDevices();
        }

        return new ArrayList<BluetoothDevice>();
    }

    public BluetoothLeService getService() {
        return bluetoothLeService;
    }

}