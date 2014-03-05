package com.gamut.android.util;

import java.math.BigInteger;

/**
 * Created by user on 3/3/14.
 */
public class ByteUtil
{
    public static byte[] GetRainbowCommand() {
        return new byte[]{ (byte)0xFC };
    }

    public static byte[] GetClearCommand() {
        return new byte[]{ (byte)0xFE };
    }

    public static byte[] GetMatrixIntensityCommand(byte brightness) {
        return new byte[]{ (byte)0xFB, brightness };
    }

    public static byte[] GetBrightnessCommand(byte brightness) {
        if (brightness < 25) {
            // Make sure the LEDs don't turn off
            brightness = 25;
        }
        return new byte[]{ (byte)0xFD, brightness };
    }

    public static byte[] GetPixelCommand(int x, int y, byte r, byte g, byte b) {
        return new byte[]{ (byte)0xFF, convertIntToByte2(x), convertIntToByte2(y), convertIntToByte2(r), convertIntToByte2(g), convertIntToByte2(b) };
    }

    private static byte convertIntToByte(int x) {
        return (byte)Integer.valueOf(String.valueOf(x), 16).intValue();
    }

    private static byte convertIntToByte2(int x) {
        final byte[] test = BigInteger.valueOf(x).toByteArray();
        if (test.length > 0) {
            return test[0];
        }

        return 0x00;
    }
}

