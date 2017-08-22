package com.hongbo.lib.activitygrouplib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import com.hongbo.lib.activitygrouplib.R;
import com.hongbo.lib.activitygrouplib.widget.ToolBarView;

/**
 * Created by sunhongbo on 17/8/21.
 */
public class ToobarImpl implements ToolBar {

    private final TextView mLeftTextView;

    private ImageView mIconView;

    private ToolBarView mToolBarView;

    private Context mContext;

    public ToobarImpl(final View decorView) {
        mContext = decorView.getContext();
        mToolBarView = (ToolBarView) decorView.findViewById(R.id.tool_bar_view);
        mIconView = (ImageView) mToolBarView.findViewById(R.id.tool_bar_icon);
        mLeftTextView = (TextView) mToolBarView.findViewById(R.id.tool_bar_left_txt);
    }

    @Override
    public ToolBar setTitle(final int resId) {
        mToolBarView.setTitle(mContext.getString(resId));
        return this;
    }

    @Override
    public ToolBar setTitle(final CharSequence text) {
        mToolBarView.setTitle(text);
        return this;
    }

    @Override
    public ToolBar setIcon(final int resId) {
        setIcon(mContext.getResources().getDrawable(resId));
        return this;
    }

    @Override
    public ToolBar setIcon(final Drawable icon) {
        mToolBarView.setIcon(icon);
        return this;
    }

    @Override
    public ToolBar setLeftText(final String icon) {
        mToolBarView.setLeftText(icon);
        return this;
    }

    @Override
    public View setCustomView(final int layoutResId) {
        return mToolBarView.setCustomView(layoutResId);
    }

    @Override
    public void setCustomView(final View view, final LayoutParams params) {
        mToolBarView.setCustomView(view, params);
    }

    @Override
    public void setOnBackIconClickListener(final View.OnClickListener listener) {
        if (mIconView.getVisibility() == View.VISIBLE) {
            mIconView.setOnClickListener(listener);
        } else {
            mLeftTextView.setOnClickListener(listener);
        }
    }
}
