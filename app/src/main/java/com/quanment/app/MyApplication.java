package com.quanment.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.StrictMode;
import android.support.multidex.MultiDex;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    public static Handler mHandler;
    private static MyApplication app;
    public static Context mContext;
    public static int countImg = 1;
//    protected AppConfig mAppConfig;

    /**
     * 打开的activity
     **/
    private List<Activity> activities = new ArrayList<Activity>();

    public static MyApplication getApp()
    {
        return app;
    }

    public static synchronized Context getAppContext() {
        if(app != null)
            return app.getApplicationContext();
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();
        app = this;
        mContext = this;
//        mAppConfig = AppConfig.getInstance();
        initApp(mContext);
    }

    /**
     * @param mContext
     */
    private void initApp(Context mContext) {
        /**
         *  初始化公共配置
         */
//        mAppConfig.initCommonConfig();
        /**
         *  Realm 数据库
         */
//        mAppConfig.initRealm();
        /**
         *   默认图片选择器
         */
//        mAppConfig.initImgPicker(countImg);
        /**
         * 更新
         */
//        mAppConfig.initBugly();
        /**
         * LeakCanary   打包改false
         */
//        mAppConfig.initLeakCanary(false);
        /**
         * 初始化分享
         */
//        mAppConfig.initShare();

    }

    /**
     * 新建了一个activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 结束指定的Activity
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            this.activities.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 应用退出，结束所有的activity
     */
    public void exit() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }

    /**
     * 关闭Activity列表中的所有Activity
     */
    public void finishActivity() {
        for (Activity activity : activities) {
            if (null != activity) {
                activity.finish();
            }
        }
        //杀死该应用进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        // 安装tinker
//        Beta.installTinker();
    }

    @TargetApi(9)
    protected void setStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
    }
}
