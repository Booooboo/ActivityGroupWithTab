package com.fragment.app.activitygroupwithtab.sample;

import android.os.Bundle;
import android.widget.TextView;

import com.hongbo.lib.activitygrouplib.Activity;
import com.hongbo.lib.activitygrouplib.ToolBar;

/**
 * Created by sunhongbo on 17/8/22.
 */
public class Note extends Activity {

    private TextView mTvDesc;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        setToolBarEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_blank);
        final ToolBar toolBar = getToolBar();
        toolBar.setTitle("右肩膀");
        toolBar.setCustomView(R.layout.tool_bar_refresh_icon);
        mTvDesc = (TextView) findViewById(R.id.tx_desc);
        mTvDesc.setText("this is 通讯录 tab");
    }
}
