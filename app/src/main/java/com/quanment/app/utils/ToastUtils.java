package com.quanment.app.utils;

import android.widget.Toast;

import com.quanment.app.MyApplication;

/**
 * 作者 by K
 * 时间：on 2017/8/28 16:30
 * 邮箱 by  vip@devkit.vip
 * <p/>
 * 类用途：
 * 最后修改：
 */
public class ToastUtils {
    private static Toast toast;
    /**
     * 强大的吐司，能够连续弹的吐司
     * @param text
     */
    public static void showToast(String text){
        if(toast==null){
            toast = Toast.makeText(MyApplication.getAppContext(), text, Toast.LENGTH_SHORT);
        }else {
            toast.setText(text);//如果不为空，则直接改变当前toast的文本
        }
        toast.show();
    }

}
