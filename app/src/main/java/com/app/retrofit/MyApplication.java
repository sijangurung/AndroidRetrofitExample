package com.app.retrofit;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

/**
 * Created by djlophu on 03/03/15.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }

}
