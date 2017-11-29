package com.easyui;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.emiya.ui.activity.BaseActivity;
import com.emiya.ui.widgets.TabEntity;
import com.emiya.util.SpannableStringUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_spannable)
    TextView mTvSpannable;
    @BindView(R.id.tl1)
    CommonTabLayout mTl1;
    @BindView(R.id.tl2)
    CommonTabLayout mTl2;

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

        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        mTabEntities.add(new TabEntity("使用说明"));
        mTabEntities.add(new TabEntity("常见问题"));
        mTabEntities.add(new TabEntity("配件耗材"));
        mTl1.setTabData(mTabEntities);
        mTl1.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        ArrayList<CustomTabEntity> mTabEntities2 = new ArrayList<>();
        mTabEntities2.add(new TabEntity("首页", R.drawable.bg_home_home_rb_checked, R.drawable.bg_home_home_rb));
        mTabEntities2.add(new TabEntity("视频区", R.drawable.bg_home_parts_rb_checked, R.drawable.bg_home_parts_rb));
        mTabEntities2.add(new TabEntity("服务支持", R.drawable.bg_home_feedback_rb_checked, R.drawable.bg_home_feedback_rb));
        mTabEntities2.add(new TabEntity("我的", R.drawable.bg_home_my_rb_checked, R.drawable.bg_home_my_rb));
        mTl2.setTabData(mTabEntities2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
