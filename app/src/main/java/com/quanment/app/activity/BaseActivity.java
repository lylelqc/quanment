package com.quanment.app.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
import com.quanment.app.model.PostResult;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;

/**
 */
public abstract class BaseActivity extends AppCompatActivity {


    public static final long MAX_DOUBLE_BACK_DURATION = 2000;
//    protected LoadingDialog loadingDialog;//加载中
    protected Context mContext;
    protected Unbinder unbinder;
    protected ImmersionBar mImmersionBar;
//    protected BaseLayoutManager mBaseLayoutManager;
    private WindowManager.LayoutParams layoutParams;
//    private PushService.MyBinder myBinder;
//    private ServiceConnection connection = new ServiceConnection() {
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            // 连接断开
//        }
//
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            myBinder = (PushService.MyBinder) service;
//            myBinder.startPushService();
//        }
//    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏应用的标题栏
        setContentView(setLayoutId());
        unbinder = ButterKnife.bind(this);
        mContext = this;
//        Logcat.i("导航栏高度" + ViewUtils.getStatusBarHeight(this) + "/" + ScreenUtils.getStatusBarHeight(this) + " 手机系统：" + OSUtils.isEMUI() + "/" + OSUtils.isFlymeOS());
        initBase();
        initData();
        initView();
//        setListener();
    }

    private void initBase() {
        /**检测app版本**/
//        Beta.checkUpgrade(false, true);
        /**多状态布局*/
        if (isBindEventBusHere()) {
            EventBus.getDefault().register(this);
        }
        initBaseLayout();
        if (isCheckNetState())
//            checkNetState(this, R.layout.layout_net_error);
        if (isImmersionBarEnabled())
            initImmersionBar();
//        Intent bindIntent = new Intent(this, PushService.class);
//        bindService(bindIntent, connection, BIND_AUTO_CREATE);
    }

    protected abstract int setLayoutId();

    protected abstract void initData();

    protected abstract void initView();

//    protected abstract void setListener();

    protected <T extends View> T $(int id) {
        return (T) super.findViewById(id);
    }

    /**
     * 是否绑定eventBus
     */
    protected abstract boolean isBindEventBusHere();

    /**
     * 接受EventBus 广播
     */
    public void onEvent(PostResult postResult) {

    }

    /**
     * startActivity
     *
     * @param clazz
     */
    protected void startActivityWithoutExtras(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity  putExtras（Bundle）
     *
     * @param clazz
     * @param extras
     */
    protected void startActivityWithExtras(Class<?> clazz, Bundle extras) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(extras);
        startActivity(intent);
    }

    /**
     * 重启当前Activity
     */
    private void reStartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    /**
     * @param mContext
     */
    protected void checkNetState(Context mContext, int layoutId) {
//        Logcat.i("NetStatus:" + NetUtils.isNetworkAvailable(mContext));
//        if (!NetUtils.isNetworkAvailable(mContext)) {
//        }
    }
    /**
     * 初始化多状态布局View
     */
    protected void initBaseLayout() {
        //  mBaseLayoutManager = BaseLayoutManager.wrap(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
        unbinder.unbind();

        if (isBindEventBusHere()) {
            EventBus.getDefault().unregister(this);
        }
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //在BaseActivity里销毁
//        unbindService(connection);// 解除绑定，断开连接

    }

    //设置android app 的字体大小不受系统字体大小改变的影响
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    /**
     * 初始化  加载
     *
     * @param str       提示内容
     * @param isOnTouch 点击外部是否关闭
     */
    public void initProgressDialog(String str, boolean isOnTouch) {
        if (!isFinishing()) {
//            loadingDialog = new LoadingDialog(mContext, R.style.loading_dialog);
//            loadingDialog.setCanceledOnTouchOutside(isOnTouch);
//            if (StringUtil.isEmpty(str)) {
//                loadingDialog.setText("加载中，请稍等...");
//            } else {
//                loadingDialog.setText(str);
//            }
//            loadingDialog.show();
        }
    }

    public void dismissProgressDialog() {
//        if (loadingDialog != null && loadingDialog.isShowing()) {
//            loadingDialog.dismiss();
//        }
    }

    public void dismissProgressDialog(boolean isUiThread) {
//        if (isUiThread == true) {
//            ThreadUtils.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    if (loadingDialog != null && loadingDialog.isShowing()) {
//                        loadingDialog.dismiss();
//                    }
//                }
//            });
//        } else {
//            if (loadingDialog != null && loadingDialog.isShowing()) {
//                loadingDialog.dismiss();
//            }
//        }
    }

    /**
     * 初始化沉浸式
     */
    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
//        mImmersionBar.init();
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    /**
     * Is CheckNetState  enabled boolean.
     *
     * @return the boolean
     */
    public boolean isCheckNetState() {
        return true;
    }

//    private LayoutManagerListener mLayoutManagerListener;
//
//    public void setLayoutManagerListener(LayoutManagerListener mLayoutManagerListener) {
//        this.mLayoutManagerListener = mLayoutManagerListener;
//    }

    /**
     * 初始化字体备用
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }
}
