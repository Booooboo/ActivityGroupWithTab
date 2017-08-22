package com.fragment.app.activitygroupwithtab.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by sunhongbo on 17/8/22.
 */
public class Home extends Activity {

    private TextView mTvDesc;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_blank);
        mTvDesc = (TextView) findViewById(R.id.tx_desc);
        mTvDesc.setText("this is 微信 tab");
    }
}
