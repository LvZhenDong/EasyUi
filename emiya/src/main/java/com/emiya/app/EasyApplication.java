package com.emiya.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;

import com.emiya.util.MySharePreferencesManager;

public abstract class EasyApplication extends MultiDexApplication {
    private static EasyApplication sApplication;

    public static EasyApplication getInstance() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;

        registerActivityLifecycle();
        initOther();
    }

    private void initOther(){
        MySharePreferencesManager.getInstance().init(this);//secure sp init
    }


    private void registerActivityLifecycle() {
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                EasyAppManager.getInstance().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                EasyAppManager.getInstance().removeActivity(activity);
            }
        });
    }
}
