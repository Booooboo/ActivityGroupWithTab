package com.hongbo.lib.activitygrouplib.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hongbo.lib.activitygrouplib.R;

/**
 * Created by sunhongbo on 17/8/21.
 */
public class ToolBarView extends FrameLayout {

    private ImageView mIconView;

    private TextView mLeftText;

    private TextView mTitleText;

    FrameLayout mCustomView;

    public ToolBarView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mIconView = (ImageView) findViewById(R.id.tool_bar_icon);
        mLeftText = (TextView) findViewById(R.id.tool_bar_left_txt);
        mTitleText = (TextView) findViewById(R.id.tool_bar_title);
        mCustomView = (FrameLayout) findViewById(R.id.tool_bar_custom);
    }

    public void setTitle(final CharSequence text) {
        mTitleText.setText(text);
    }

    public void setIcon(final Drawable icon) {
        if (icon == null) {
            mIconView.setVisibility(GONE);
        } else {
            mLeftText.setVisibility(GONE);
            mIconView.setVisibility(VISIBLE);
            mIconView.setImageDrawable(icon);
        }
    }

    public void setLeftText(String text) {
        if (text == null) {
            mLeftText.setVisibility(GONE);
        } else {
            mIconView.setVisibility(GONE);
            mLeftText.setVisibility(VISIBLE);
            mLeftText.setText(text);
        }
    }

    public View setCustomView(final int layoutResId) {
        mCustomView.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(layoutResId, mCustomView, false);
        mCustomView.addView(view);
        return view;
    }

    public void setCustomView(final View view, ViewGroup.LayoutParams params) {
        mCustomView.removeAllViews();
        mCustomView.addView(view, params);
    }

}
