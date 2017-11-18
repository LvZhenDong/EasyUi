package com.emiya.mvp;



public interface IPresenter<V extends IView> {
    void attachView(V view);

    void detachView(boolean retainInstance);
}
