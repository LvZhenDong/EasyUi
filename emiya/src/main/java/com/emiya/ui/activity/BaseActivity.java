package com.emiya.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.michaelflisar.rxbus2.rx.RxDisposableManager;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends RxAppCompatActivity {
    public final static String KEY_INTENT = "intent data";
    public final static String KEY_INTENT_BOOLEAN = "intent data boolean";

    protected Unbinder unbinder;

    public abstract int returnLayoutID();

    public abstract void TODO(Bundle savedInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  //强制竖屏
        setContentView(returnLayoutID());
        unbinder = ButterKnife.bind(this);
        setOthers(savedInstanceState);
    }

    protected void setOthers(Bundle savedInstanceState) {
        TODO(savedInstanceState);
    }

    /**
     * get context
     *
     * @return
     */
    public Context getContext() {
        return this;
    }

    /**
     * get activity
     *
     * @return
     */
    public Activity getActivity() {
        return this;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        RxDisposableManager.unsubscribe(this);
    }

    public void baseStartActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

}
