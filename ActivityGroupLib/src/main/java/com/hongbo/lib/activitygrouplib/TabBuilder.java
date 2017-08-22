package com.hongbo.lib.activitygrouplib;

/**
 * Created by sunhongbo on 17/8/21.
 */
public interface TabBuilder {

    Tab newTab();

    TabBuilder addTab(Tab tab);

    void build();
}