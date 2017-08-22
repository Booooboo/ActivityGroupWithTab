package com.hongbo.lib.activitygrouplib;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * Created by sunhongbo on 17/8/21.
 */
public interface ToolBar {

    ToolBar setTitle(final int resId);

    ToolBar setTitle(final CharSequence text);

    ToolBar setIcon(final int resId);

    ToolBar setIcon(final Drawable icon);

    ToolBar setLeftText(final String text);

    View setCustomView(final int layoutResId);

    void setCustomView(final View view, LayoutParams lp);

    void setOnBackIconClickListener(final View.OnClickListener listener);
}


