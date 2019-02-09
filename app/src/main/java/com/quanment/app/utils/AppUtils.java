package com.quanment.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Family on 2019/2/6
 */
public class AppUtils {

    /**
     * @description: Activity跳转
     * @param context
     * @param activity 目标Activity
     */
    public static void goActivity(Context context, Class<?> activity) {
        goActivity(context,activity,null);
    }


    /**
     * @description: Activity跳转
     * @param context
     * @param activity 目标Activity
     * @param bundle 携带的数据
     */
    public static void goActivity(Context context, Class<?> activity,Bundle bundle) {
        goActivity(context,activity,bundle,false);
    }

    /**
     * @description: Activity跳转
     * @param context
     * @param activity 目标Activity
     * @param bundle 携带的数据
     * @param isFinish
     */
    public static void goActivity(Context context, Class<?> activity, Bundle bundle, boolean isFinish) {
        Intent intent = new Intent();
        intent.setClass(context, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
        if(isFinish){
            ((Activity)context).finish();
        }
    }

}
