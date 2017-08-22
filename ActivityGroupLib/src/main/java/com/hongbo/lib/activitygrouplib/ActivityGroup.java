package com.hongbo.lib.activitygrouplib;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sunhongbo on 17/8/21.
 */
@Deprecated
public class ActivityGroup extends android.app.ActivityGroup implements OnCheckedChangeListener {

    private ActivityDelegate mActivityDelegate;

    private List<TabImpl> mTabs = Collections.emptyList();

    private RadioGroup mTabBar;

    private FrameLayout mContentLayout;

    private LocalActivityManager mLocalActivityManager;

    private View mMaskView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityDelegate = ActivityDelegates.create(this);
        mActivityDelegate.onCreate(savedInstanceState);
        mLocalActivityManager = getLocalActivityManager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActivityDelegate.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mActivityDelegate.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mActivityDelegate.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityDelegate.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mActivityDelegate.onStart();
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
    public void onContentChanged() {
        super.onContentChanged();
        mContentLayout = (FrameLayout) findViewById(R.id.content);
        mTabBar = (RadioGroup) findViewById(R.id.tab_bar);
        mTabBar.setOnCheckedChangeListener(this);
        mMaskView = findViewById(R.id.mask);
    }

    public void setCurrentTab(final int id) {
        mTabBar.check(id);
    }

    public void showMaskView(final boolean show) {
        mMaskView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private void onCreateTab(TabBuilderImpl builder) {
        mTabs = builder.mTabs;
        for (TabImpl tab : mTabs) {
            if (tab.layoutResId != View.NO_ID) {
                getLayoutInflater().inflate(tab.layoutResId, mTabBar, true);
            } else if (tab.view != null) {
                mTabBar.addView(tab.view);
            } else {
                mTabBar.addView(createTabView(tab));
            }
        }
    }

    private RadioButton createTabView(TabImpl tab) {
        RadioButton tabView = (RadioButton) getLayoutInflater().inflate(R.layout.tab, mTabBar, false);
        tabView.setText(tab.text);
        tabView.setCompoundDrawablesWithIntrinsicBounds(null, tab.icon, null, null);
        if (tab.background != null) {
            tabView.setBackgroundDrawable(tab.background);
        }
        tabView.setId(tab.id);
        return tabView;
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

    public void onBackIconClick() {
        // override this method to handle back icon click event
    }

    @Override
    public void onCheckedChanged(final RadioGroup group, final int checkedId) {
        final Tab tab = getTab(checkedId);
        if (tab == null) {
            return;
        }

        View view = mLocalActivityManager.startActivity(String.valueOf(checkedId), getTabIntent(tab)).getDecorView();
        if (view.getParent() == null) {
            mContentLayout.addView(view);
        }

        // FIXME:
        for (int i = 0; i < mContentLayout.getChildCount(); i++) {
            mContentLayout.getChildAt(i).setVisibility(View.GONE);
        }
        view.setVisibility(View.VISIBLE);
    }

    protected Intent getTabIntent(final Tab tab) {
        final Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setClass(this, tab.getClazz());
        return intent;
    }

    private Tab getTab(final int id) {
        for (Tab tab : mTabs) {
            if (tab.getId() == id) {
                return tab;
            }
        }

        return null;
    }

    public TabBuilder createTabBuilder() {
        return new TabBuilderImpl();
    }

    class TabBuilderImpl implements TabBuilder {

        ArrayList<TabImpl> mTabs = new ArrayList<TabImpl>();

        @Override
        public Tab newTab() {
            return new TabImpl();
        }

        public TabBuilder addTab(Tab tab) {
            mTabs.add((TabImpl) tab);
            return this;
        }

        @Override
        public void build() {
            onCreateTab(this);
        }
    }
}


