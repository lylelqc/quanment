package com.quanment.app.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.quanment.app.R;
import com.quanment.app.activity.BusinessListActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ClassifyFragment extends BaseFragment {

    @BindView(R.id.ll_classify_zhusu)
    LinearLayout mClassifyZhusu;
    @BindView(R.id.ll_classify_shoujiweixiu)
    LinearLayout mClassifyMobileRepair;

    public static String mContent = "???";

    public static ClassifyFragment newInstance(String content) {
        ClassifyFragment fragment = new ClassifyFragment();
        fragment.mContent = content;
        return fragment;
    }

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_classify;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected void initImmersionBar() {
        ImmersionBar.with(this).statusBarColorTransformEnable(false)
                .keyboardEnable(true)
                .navigationBarColor(R.color.colorPrimary).init();
    }


    @OnClick({R.id.ll_classify_zhusu, R.id.ll_classify_shoujiweixiu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_classify_zhusu:
            case R.id.ll_classify_shoujiweixiu:
                Intent intent = new Intent(mContext, BusinessListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
