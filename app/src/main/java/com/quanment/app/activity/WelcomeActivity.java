package com.quanment.app.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.WindowManager;

import com.quanment.app.R;
import com.quanment.app.utils.ToastUtils;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends BaseActivity {

    private long lastBackKeyDownTick = 0;

    private SharedPreferences sharepreferences;//实例化 SharedPreferences
    private SharedPreferences.Editor editor;


    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.transparentBar().init();
    }

    @Override
    public boolean isCheckNetState() {
        return  false;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initData() {
        sharepreferences = this.getSharedPreferences("check", MODE_PRIVATE);// 初始化 SharedPreferences 储存
        editor = sharepreferences.edit();
        proInspect(this);
        isFirstStart(this);
        initProData(this);
    }

    @Override
    protected void initView() {
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    /**
     * 重新安装/或更新之后删除数据库的时候
     *
     * @param welcomeActivity
     */
    private void initProData(WelcomeActivity welcomeActivity) {
        try {
            PackageManager packageManager = getApplicationContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            //应用装时间
            long firstInstallTime = packageInfo.firstInstallTime;
            //应用最后一次更新时间
            long lastUpdateTime = packageInfo.lastUpdateTime;
            if (lastUpdateTime > firstInstallTime) {
                if (lastUpdateTime == System.currentTimeMillis()) {
//                    RealmConfiguration config = new RealmConfiguration.Builder().build(); // 默认的 RealmConfiguration
//                    Realm.deleteRealm(config); // 清除数据
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    // TODO: 2017/8/29  程序安检

    /**
     * 用于初始化/检查程序
     *
     * @param mContext
     */
    private void proInspect(Context mContext) {

    }

    /**
     * @param mContext
     */
    public void isFirstStart(Context mContext) {
        boolean isFirstS = sharepreferences.getBoolean("isFirstStart", true);
        if (isFirstS) {
            proStartActivity(mContext, true);
            editor.putBoolean("isFirstStart", false);//第一次启动后
            editor.commit();
        } else {
            proStartActivity(mContext, false);
        }
    }

    /**
     * @param mContext
     * @param isFirst
     */
    private void proStartActivity(final Context mContext, final boolean isFirst) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (isFirst) {
                    startActivity(new Intent(mContext, MainActivity.class));
                } else {
                    startActivity(new Intent(mContext, MainActivity.class));
                }
                finish();
            }
        };
        // 设置不同的延迟启动时间
        if (isFirst) {
            timer.schedule(task, 1000 * 1);
        } else {
            timer.schedule(task, 1000 * 2);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        long currentTick = System.currentTimeMillis();
        if (currentTick - lastBackKeyDownTick > MAX_DOUBLE_BACK_DURATION) {
            ToastUtils.showToast(getString(R.string.tips_exit));
            lastBackKeyDownTick = currentTick;
        } else {
            finish();
            System.exit(0);
        }
    }
}
