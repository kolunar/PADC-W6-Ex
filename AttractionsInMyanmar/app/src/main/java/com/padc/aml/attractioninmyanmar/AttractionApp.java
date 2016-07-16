package com.padc.aml.attractioninmyanmar;

import android.app.Application;
import android.content.Context;

/**
 * Created by user on 7/9/2016.
 */
public class AttractionApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
