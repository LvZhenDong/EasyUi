package com.easyui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.emiya.ui.activity.BaseActivity;
import com.emiya.util.DensityUtils;
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;

    @Override
    public int returnLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void TODO(Bundle savedInstanceState) {
        initTopBar();
    }

    private void initTopBar() {
        mTopBar.setBackgroundColor(getResources().getColor(R.color.green));

        //设置Title
        TextView tvTitle = mTopBar.setTitle("首页");
        tvTitle.setTextColor(getResources().getColor(R.color.white));
        tvTitle.setBackgroundResource(R.drawable.bg_home_logo);
        tvTitle.setText("");

        //设置left Button
        leftBtn = mTopBar.addLeftBackImageButton();
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        leftBtn.setImageResource(R.drawable.ic_msg_white);

        //设置right Button
        int rightBtnId;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN)
            rightBtnId = View.generateViewId();
        else
            rightBtnId = 1993;
        mTopBar.addRightImageButton(R.drawable.ic_phone_gray, rightBtnId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "right btn click", Toast.LENGTH_SHORT).show();
            }
        });

        //关闭按钮
        int closeBtnId;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN)
            closeBtnId = View.generateViewId();
        else
            closeBtnId = 1994;
        mTopBar.addLeftImageButton(R.drawable.ic_close, closeBtnId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "close btn click", Toast.LENGTH_SHORT).show();
            }
        });

        leftBtn.post(new Runnable() {
            @Override
            public void run() {
                showRedDot();
            }
        });
    }
    QMUIAlphaImageButton leftBtn;
    ImageView mRedDotIV;
    /**
     * 设置消息红点提示的位置
     */
    private void setRedDotLocation() {
        int width = leftBtn.getWidth();
        int height = leftBtn.getHeight();

        mRedDotIV.setX(width / 2 + DensityUtils.dp2px(this, 2));
        mRedDotIV.setY(height / 4);
    }

    public void showRedDot() {
        if (mRedDotIV == null) {
            mRedDotIV = new ImageView(this);
            mTopBar.addView(mRedDotIV);
        }
        mRedDotIV.setVisibility(View.VISIBLE);
        setRedDotLocation();
        mRedDotIV.setImageResource(R.drawable.shape_oval_red);
    }


    public void hideRedDot() {
        if (mRedDotIV != null) {
            mRedDotIV.setVisibility(View.GONE);
        }
    }
}
