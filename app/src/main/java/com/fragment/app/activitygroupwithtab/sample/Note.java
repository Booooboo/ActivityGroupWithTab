package com.fragment.app.activitygroupwithtab.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by sunhongbo on 17/8/22.
 */
public class Note extends Activity {

    private TextView mTvDesc;

    private int mType;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_blank);
        mTvDesc = (TextView) findViewById(R.id.tx_desc);
        mTvDesc.setText("this is 通讯录 tab");
    }
}
