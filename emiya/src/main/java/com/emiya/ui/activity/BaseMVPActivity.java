package com.emiya.ui.activity;

import com.emiya.mvp.IMvpBase;
import com.emiya.mvp.IPresenter;
import com.emiya.mvp.IView;
import com.emiya.util.DialogHelper;

import cc.cloudist.acplibrary.ACProgressFlower;

public abstract class BaseMVPActivity<V extends IView, P extends IPresenter<V>> extends
        BaseActivity implements IMvpBase<V> {

    protected P presenter;

    public abstract P createPresenter();

    protected ACProgressFlower mDialog;

    @Override
    protected void beforeToDo() {
        mDialog = DialogHelper.createProgressDialog(this);
        presenter = createPresenter();
        presenter.attachView(getMvpView());
    }

    @Override
    public V getMvpView() {
        return (V) this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }
}
