package com.calone.vpgilt;

import android.app.Application;
import android.content.Context;

/**
 * Created by babas on 03/07/18.
 */

public class VPApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
