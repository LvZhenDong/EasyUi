package com.easyui;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.emiya.ui.activity.BaseActivity;
import com.emiya.util.SpannableStringUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_spannable)
    TextView mTvSpannable;

    @Override
    public int returnLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void toDo(Bundle savedInstanceState) {
        initTopBar();
    }

    @Override
    protected int returnTopBarId() {
        return R.id.top_bar;
    }

    private void initTopBar() {
        //设置Title
        setTopBarTitle(R.string.home);
        setTopBarBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

        SpannableStringBuilder spannableStringBuilder = SpannableStringUtils.getBuilder("一二34五")
                .setForegroundColor(getResources().getColor(R.color.red))
                .append("text2").setForegroundColor(getResources().getColor(R.color.colorPrimary))
                .create();
        mTvSpannable.setText(spannableStringBuilder);
    }

}
