package com.hongbo.lib.activitygrouplib;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

/**
 * Created by sunhongbo on 17/8/21.
 */
public interface Tab {

    CharSequence getText();

    Tab setText(final CharSequence text);

    Drawable getIcon();

    Tab setIcon(final Drawable icon);

    Drawable getBackground();

    Tab setBackground(final Drawable background);

    Class<?> getClazz();

    Tab setClazz(final Class<?> clazz);

    Bundle getArgs();

    Tab setArgs(final Bundle args);

    int getId();

    Tab setId(final int id);

    Tab setCustomView(final View view);

    Tab setCustomView(final int layoutResId);
}

