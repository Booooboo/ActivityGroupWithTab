package com.hongbo.lib.activitygrouplib;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;


/**
 * Created by sunhongbo on 17/8/21.
 */
abstract class AbstractActivityDelegate<T extends Activity> implements ActivityDelegate<T> {

    private boolean mToorBarEnabled;

    private T mActivity;

    public AbstractActivityDelegate(T activty) {
        mActivity = activty;
    }

    protected T getActivity() {
        return mActivity;
    }

    @Override
    public void onCreate(final Bundle saveInstanceState) {

    }

    @Override
    public void onStart() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void setContentView(final int layoutResId) {
        setContentView(mActivity.getLayoutInflater().inflate(layoutResId, null, false));
    }

    @Override
    public void setContentView(final View view) {
        setContentView(view, null);
    }

    public abstract void setContentView(final View view, final LayoutParams params);

    @Override
    public void setToolBarEnabled(final boolean enabled) {
        mToorBarEnabled = enabled;
    }

    @Override
    public Dialog onCreateDialog(final int id, final Bundle args) {
        return null;
    }

    @Override
    public void onPrepareDialog(final int id, final Dialog dialog, final Bundle args) {
    }

    protected int getLayoutResId() {
        return hasWindowToolBar() ? R.layout.activity : R.layout.activity_no_title;
    }

    protected boolean hasWindowToolBar() {
        TypedValue outValue = new TypedValue();
        mActivity.getTheme().resolveAttribute(R.attr.windowActionBar, outValue, true);
        return outValue.data == 0 || mToorBarEnabled;
    }

}
