package com.hongbo.lib.activitygrouplib;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sunhongbo on 17/8/21.
 */
public class Activity extends FragmentActivity
{

    private final String mNetTag = toString();

    private boolean mToolBarEnabled;

    private ActivityDelegate mActivityDelegate;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityDelegate = ActivityDelegates.create(this);
        if (mToolBarEnabled) {
            mActivityDelegate.setToolBarEnabled(mToolBarEnabled);
        }
        mActivityDelegate.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityDelegate.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mActivityDelegate.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActivityDelegate.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mActivityDelegate.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mActivityDelegate.onStop();
    }

    @Override
    public final void setContentView(int layoutResId) {
        mActivityDelegate.setContentView(layoutResId);
    }

    @Override
    public final void setContentView(View view) {
        mActivityDelegate.setContentView(view);
    }

    @Override
    public final void setContentView(View view, ViewGroup.LayoutParams params) {
        mActivityDelegate.setContentView(view, params);
    }

    @Override
    protected Dialog onCreateDialog(final int id, final Bundle args) {
        return mActivityDelegate.onCreateDialog(id, args);
    }

    @Override
    protected void onPrepareDialog(final int id, final Dialog dialog, final Bundle args) {
        mActivityDelegate.onPrepareDialog(id, dialog, args);
    }

    public void onBackIconClick() {
        // override this method to handle back icon click event
    }

    public void setToolBarEnabled(final boolean enabled) {
        mToolBarEnabled = enabled;
    }

    public ToolBar getToolBar() {
        return mActivityDelegate.getToolBar();
    }

    final void setContentViewInternal(int layoutResId) {
        super.setContentView(layoutResId);
    }

    final void setContentViewInternal(View view) {
        super.setContentView(view);
    }

    final void setContentViewInternal(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    public final Dialog onCreateDialogInternal(final int id, final Bundle args) {
        return super.onCreateDialog(id, args);
    }

    public final void onPrepareDialogInternal(final int id, final Dialog dialog, final Bundle args) {
        super.onPrepareDialog(id, dialog, args);
    }

    public Dialog getWaitingDialog() {
        return null;
    }
}

