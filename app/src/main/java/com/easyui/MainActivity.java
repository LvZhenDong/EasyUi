package com.easyui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.emiya.ui.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int returnLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void TODO(Bundle savedInstanceState) {
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
    }
}
