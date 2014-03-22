package com.gamut.android;

import android.app.Application;
import android.content.Context;

import com.gamut.android.services.BluetoothLeService;
import com.google.sample.castcompanionlibrary.cast.DataCastManager;

/**
 * Created by user on 3/3/14.
 */
public class GamutApplication extends Application {

    private static DataCastManager mCastMgr;

    @Override
    public void onCreate() {
        super.onCreate();
        BluetoothLeService.createInstance(this);
    }

    public static DataCastManager getVideoCastManager(Context ctx) {
        if (null == mCastMgr) {
            mCastMgr = DataCastManager.initialize(ctx, ctx.getString(R.string.app_id),
                    ctx.getString(R.string.namespace));
            mCastMgr.enableFeatures(DataCastManager.FEATURE_NOTIFICATION |
                    DataCastManager.FEATURE_LOCKSCREEN |
                    DataCastManager.FEATURE_DEBUGGING);
        }
        mCastMgr.setContext(ctx);
        return mCastMgr;
    }
}
