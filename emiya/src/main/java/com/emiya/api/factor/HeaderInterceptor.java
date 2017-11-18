package com.emiya.api.factor;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public abstract class  HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        String token = getToken();
        Request.Builder builder = original.newBuilder();
        if (!TextUtils.isEmpty(token)){
            builder.addHeader("token",token);
        }
        return chain.proceed(builder.build());
    }

    abstract String getToken();
}
