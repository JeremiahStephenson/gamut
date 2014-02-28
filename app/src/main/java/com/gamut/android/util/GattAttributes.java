package com.gamut.android.util;

import java.util.UUID;

/**
 * Created by user on 2/27/14.
 */
public class GattAttributes {

    public static final UUID CLIENT_CHARACTERISTIC_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public static final UUID BLE_SHIELD_TX = UUID.fromString("713d0003-503e-4c75-ba94-3148f18d941e");
    public static final UUID BLE_SHIELD_RX = UUID.fromString("713d0002-503e-4c75-ba94-3148f18d941e");
    public static final UUID BLE_SHIELD_SERVICE = UUID.fromString("713d0000-503e-4c75-ba94-3148f18d941e");
}
