package com.hongbo.lib.activitygrouplib;

/**
 * Created by sunhongbo on 17/8/21.
 */
final class ActivityDelegates {

    private ActivityDelegates() {
    }

    public static ActivityDelegate create(Activity activity) {
        return new ActivityDelegateImpl(activity);
    }

    public static ActivityDelegate create(ActivityGroup activity) {
        return new ActivityGroupDelegateImpl(activity);
    }
}
