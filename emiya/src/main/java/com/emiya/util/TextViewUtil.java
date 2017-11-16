package com.emiya.util;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/**
 * author lzd
 * date 2017/9/6 16:52
 * 类描述：
 */

public class TextViewUtil {

    public static void setText(TextView tv,String text){
        if(TextUtils.isEmpty(text)){
            tv.setVisibility(View.GONE);
        }else {
            tv.setVisibility(View.VISIBLE);
            tv.setText(text);
        }
    }

    public static void setText(TextView tv,String head,String text){
        if(TextUtils.isEmpty(text)){
            tv.setVisibility(View.GONE);
        }else {
            tv.setVisibility(View.VISIBLE);
            tv.setText(head+text);
        }
    }
}
