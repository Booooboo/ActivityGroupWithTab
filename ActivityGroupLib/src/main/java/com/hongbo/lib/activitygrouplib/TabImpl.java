package com.hongbo.lib.activitygrouplib;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

/**
 * Created by sunhongbo on 17/8/21.
 */
public class TabImpl implements Tab {

    CharSequence text;

    Drawable icon;

    Drawable background;

    Class<?> clazz;

    Bundle args;

    View view;

    int layoutResId = View.NO_ID;

    int id;

    @Override
    public CharSequence getText() {
        return text;
    }

    @Override
    public Tab setText(final CharSequence text) {
        this.text = text;
        return this;
    }

    @Override
    public Drawable getIcon() {
        return icon;
    }

    @Override
    public Tab setIcon(final Drawable icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public Drawable getBackground() {
        return background;
    }

    @Override
    public Tab setBackground(final Drawable background) {
        this.background = background;
        return this;
    }

    @Override
    public Class<?> getClazz() {
        return clazz;
    }

    @Override
    public Tab setClazz(final Class<?> clazz) {
        this.clazz = clazz;
        return this;
    }

    @Override
    public Bundle getArgs() {
        return args;
    }

    @Override
    public TabImpl setArgs(Bundle args) {
        this.args = args;
        return this;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Tab setId(final int id) {
        this.id = id;
        return this;
    }

    @Override
    public Tab setCustomView(final View view) {
        this.view = view;
        return this;
    }

    @Override
    public Tab setCustomView(final int layoutResId) {
        this.layoutResId = layoutResId;
        return this;
    }
}

