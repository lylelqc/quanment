package com.quanment.app.activity;

import android.graphics.Color;
import android.graphics.Paint;
import android.widget.TextView;

import com.quanment.app.R;

import butterknife.BindView;

/**
 * Created by Family on 2019/2/7
 */
public class LoginActivity extends BaseActivity{

    @BindView(R.id.tv_forgot_pwd)
    TextView mLoginForgotPwd;
    @BindView(R.id.tv_register_account)
    TextView mLoginRegisterAccount;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setTextViewLine(mLoginForgotPwd);
        setTextViewLine(mLoginRegisterAccount);
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    private void setTextViewLine(TextView tv) {
        Paint paint = tv.getPaint();
        paint.setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        paint.setAntiAlias(true);//抗锯齿
        tv.setTextColor(getResources().getColor(R.color.app_text_red1));
    }
}
