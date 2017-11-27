package com.emiya.ui.RecyclerView;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

/**
 * 数组Adapter
 *
 * @author LvZhenDong
 *         created on 2017/11/27 11:45
 */
public abstract class ArrayAdapter<T> extends CommonAdapter<T> {
    private int mTvId;

    public ArrayAdapter(@NonNull Context context, @LayoutRes int layoutId, @IdRes int tvId) {
        super(context, layoutId);
        mTvId = tvId;
    }

    public ArrayAdapter(@NonNull Context context, @LayoutRes int layoutId, @IdRes int tvId, List<T> datas) {
        super(context, layoutId, datas);
        mTvId = tvId;
    }

    public ArrayAdapter(@NonNull Context context, @LayoutRes int layoutId, @IdRes int tvId, T[] datas) {
        super(context, layoutId, Arrays.asList(datas));
        mTvId = tvId;
    }

    @Override
    public void convert(ViewHolder holder, T t) {
        holder.setText(mTvId, convert2String(t));
    }

    public abstract String convert2String(T t);
}
