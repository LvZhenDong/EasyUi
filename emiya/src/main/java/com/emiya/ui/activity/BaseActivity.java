package com.emiya.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;

import com.emiya.R;
import com.michaelflisar.rxbus2.rx.RxDisposableManager;
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends RxAppCompatActivity {

    public final static String KEY_INTENT = "intent data";
    public final static String KEY_INTENT_BOOLEAN = "intent data boolean";

    /*****TopBar相关View start*****/
    QMUITopBar mTopBar;
    TextView mTvTitle;
    QMUIAlphaImageButton mBtnLeft;
    /*****TopBar相关View end*******/

    protected Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  //强制竖屏
        setContentView(returnLayoutID());
        unbinder = ButterKnife.bind(this);
        beforeToDo();
        toDo(savedInstanceState);
    }

    public abstract int returnLayoutID();

    protected void beforeToDo() {

    }

    public abstract void toDo(Bundle savedInstanceState);

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
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        RxDisposableManager.unsubscribe(this);
    }

    public void baseStartActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    /**
     * 设置TopBar title内容
     *
     * @param id
     */
    public void setTopBarTitle(@StringRes int id) {
        setTopBarTitle(getString(id));
    }

    /**
     * 设置TopBar title内容
     *
     * @param title
     */
    public void setTopBarTitle(String title) {
        if (mTopBar == null) {
            mTopBar = createTopBar();
        }
        mTvTitle.setText(title);
    }

    /**
     * 设置TopBar的title color
     *
     * @param color
     */
    public void setTopBarTitleColor(int color) {
        if (mTopBar == null) {
            mTopBar = createTopBar();
        }
        mTvTitle.setTextColor(color);
    }

    /**
     * 设置TopBar的返回键的listener
     *
     * @param listener
     */
    public void setTopBarBackListener(View.OnClickListener listener) {
        if (mTopBar == null) {
            mTopBar = createTopBar();
        }
        mBtnLeft.setOnClickListener(listener);
    }

    public void disableLeftBtn(){
        mBtnLeft.setVisibility(View.GONE);
    }

    private QMUITopBar createTopBar() {
        QMUITopBar topBar = (QMUITopBar) findViewById(returnTopBarId());
        mTvTitle = topBar.setTitle("title");    //必须设置个非null的值，不然title不可见
        mTvTitle.setTextColor(getResources().getColor(R.color.white));
        mBtnLeft = topBar.addLeftBackImageButton();
        mBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        return topBar;
    }

    /**
     * 返回TopBar的Id
     *
     * @return
     */
    protected int returnTopBarId() {
        throw new RuntimeException("要使用TopBar的话必须重写returnTopBarId()方法，返回TopBar的id");
    }
}
