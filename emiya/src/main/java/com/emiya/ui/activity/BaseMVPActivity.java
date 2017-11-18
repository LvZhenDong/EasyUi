package com.emiya.ui.activity;

import com.emiya.mvp.IMvpBase;
import com.emiya.mvp.IPresenter;
import com.emiya.mvp.IView;

public abstract class BaseMVPActivity<V extends IView, P extends IPresenter<V>> extends
        BaseActivity implements IMvpBase<V> {

    protected P presenter;

    public abstract P createPresenter();

    @Override
    protected void beforeToDo() {
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
