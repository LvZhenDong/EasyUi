package com.emiya.ui.RecyclerView;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas = new ArrayList<>();
    protected LayoutInflater mInflater;


    public CommonAdapter(@NonNull Context context, @LayoutRes int layoutId) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
    }

    public CommonAdapter(@NonNull Context context, @LayoutRes int layoutId, List<T> datas) {
        this(context, layoutId);
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, parent, mLayoutId);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        convert(holder, mDatas.get(position));
    }

    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public List<T> getDataList() {
        return mDatas;
    }

    public void setDataList(List<T> list) {
        mDatas.clear();
        mDatas.addAll(list);
        notifyDataSetChanged();
    }

    public void add(T t) {
        if (mDatas.add(t)) {
            notifyItemInserted(mDatas.size());
        }
    }

    public void addAll(Collection<T> list) {
        int lastIndex = mDatas.size();
        if (mDatas.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

    public void addAll(int index, Collection<T> list) {
        if (mDatas.addAll(index, list)) {
            notifyItemRangeInserted(index, list.size());
        }
    }

    public void remove(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);

        if (position != (getDataList().size())) { // 如果移除的是最后一个，忽略
            notifyItemRangeChanged(position, mDatas.size() - position);
        }
    }

    public void remove(T t) {
        mDatas.remove(t);
        notifyDataSetChanged();
    }

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }
}