package com.emiya.util;

import android.content.Context;
import android.graphics.Color;
import com.emiya.R;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;


public class DialogHelper {

    public static ACProgressFlower createProgressDialog(Context context) {
        return createProgressDialog(context, context.getString(R.string.waiting));
    }

    public static ACProgressFlower createProgressDialog(Context context, String title) {
        ACProgressFlower dialog = new ACProgressFlower.Builder(context)
                .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                .themeColor(Color.WHITE)
                .text(title)
                .fadeColor(Color.DKGRAY).build();
        return dialog;
    }
}
