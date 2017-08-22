package com.hongbo.lib.activitygrouplib;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;



/**
 * Created by sunhongbo on 17/8/21.
 */
class ActivityGroupDelegateImpl extends AbstractActivityDelegate<ActivityGroup> {

    private ToolBarImpl mToolBar;

    public ActivityGroupDelegateImpl(final ActivityGroup activity) {
        super(activity);
        setContentView(null);
    }

    @Override
    public void setContentView(final View view, final LayoutParams params) {
        final ActivityGroup activity = getActivity();
        final ViewGroup rootView = (ViewGroup) activity.getLayoutInflater().inflate(getLayoutResId(), null);

        if (view != null) {
            final ViewGroup contentView = (ViewGroup) rootView.findViewById(R.id.content);
            if (params == null) {
                contentView.addView(view, new LayoutParams(MATCH_PARENT, MATCH_PARENT));
            } else {
                contentView.addView(view, params);
            }
        }

        if (hasWindowToolBar()) {
            mToolBar = new ToolBarImpl(rootView);
            mToolBar.setOnBackIconClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    activity.onBackIconClick();
                }
            });
        }

        activity.setContentViewInternal(rootView);
    }

    protected int getLayoutResId() {
        return hasWindowToolBar() ? R.layout.activity_group : R.layout.activity_group_no_title;
    }

    @Override
    public ToolBar getToolBar() {
        return mToolBar;
    }
}

