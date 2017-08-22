package com.hongbo.lib.activitygrouplib;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sunhongbo on 17/8/21.
 */
public interface ActivityDelegate<T extends Activity> {

    void onCreate(Bundle saveInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void setContentView(int layoutResId);

    void setContentView(View view);

    void setContentView(View view, ViewGroup.LayoutParams params);

    ToolBar getToolBar();

    void setToolBarEnabled(boolean enabled);

    Dialog onCreateDialog(final int id, final Bundle args);

    void onPrepareDialog(final int id, final Dialog dialog, Bundle args);
}
