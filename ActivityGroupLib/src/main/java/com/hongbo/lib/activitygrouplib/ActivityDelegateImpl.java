package com.hongbo.lib.activitygrouplib;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;



/**
 * Created by sunhongbo on 17/8/21.
 */
public class ActivityDelegateImpl extends AbstractActivityDelegate<Activity> {

    private ToolBarImpl mToolBar;

    public ActivityDelegateImpl(Activity activity) {
        super(activity);
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setContentView(final View view, final LayoutParams params) {
        final Activity activity = getActivity();
        final ViewGroup rootView = (ViewGroup) activity.getLayoutInflater()
                .inflate(getLayoutResId(), null);

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

    @Override
    public ToolBar getToolBar() {
        return mToolBar;
    }
}
