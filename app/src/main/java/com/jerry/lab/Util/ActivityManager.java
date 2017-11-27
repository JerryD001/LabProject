package com.jerry.lab.Util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jerry
 * @date 2017/11/24
 */
public class ActivityManager {

    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
