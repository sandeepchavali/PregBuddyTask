package com.PregBuddyTask;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by chavali on 2018-03-24.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SugarContext.init(this);

    }
}
