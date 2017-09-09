package com.fragment.app.activitygroupwithtab.sample;

import android.os.Bundle;
import android.widget.TextView;

import com.hongbo.lib.activitygrouplib.Activity;
import com.hongbo.lib.activitygrouplib.ToolBar;

/**
 * Created by sunhongbo on 17/8/22.
 */
public class Home extends Activity {

    private TextView mTvDesc;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        setToolBarEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_blank);
        final ToolBar toolBar = getToolBar();
        toolBar.setTitle("测试标题");
        toolBar.setLeftText("左肩/可图");
        mTvDesc = (TextView) findViewById(R.id.tx_desc);
        mTvDesc.setText("this is 微信 tab");
    }
}
