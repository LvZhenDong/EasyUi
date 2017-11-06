package com.emiya.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.emiya.R;

/**
 * author lzd
 * date 2017/9/29 22:21
 * 类描述：
 */

public class GlideUtils {
    private static RequestOptions requestOptions = new RequestOptions();
    private static RequestOptions circleRequestOptions = RequestOptions.circleCropTransform();

    public static void load(String url, ImageView view) {
        Glide.with(view.getContext().getApplicationContext())
                .load(url)
                .apply(requestOptions.placeholder(R.color.gray)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(view);
    }

    public static void load(int resId, ImageView view) {

        Glide.with(view.getContext().getApplicationContext())
                .load(resId)
                .apply(requestOptions.placeholder(R.color.gray)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(view);
    }

    public static void loadCircleImg(String url, ImageView view) {
        Glide.with(view.getContext().getApplicationContext())
                .load(url)
                .apply(circleRequestOptions
                        .placeholder(R.drawable.ic_head)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(view);
    }

    public static void loadLocalImg(int resId, ImageView view) {
        Glide.with(view.getContext())
                .load(resId)
                .into(view);
    }

    public static void loadLocalImg(String path, ImageView view) {
        Glide.with(view.getContext())
                .load(path)
                .into(view);
    }

    public static void perLoadImg(Context context, String url) {
        Glide.with(context)
                .load(url)
                .apply(requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .preload();
    }
}
