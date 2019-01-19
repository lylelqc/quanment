package com.quanment.app.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.quanment.app.EventBusTags;
import com.quanment.app.R;
import com.quanment.app.activity.BusinessListActivity;
import com.quanment.app.activity.MainActivity;
import com.quanment.app.model.PostResult;
import com.quanment.app.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class HomeFragment extends BaseFragment{

    @BindView(R.id.ll_home_on_sale)
    LinearLayout llHomeOnSale;
    @BindView(R.id.ll_home_shoujiweixiu)
    LinearLayout llHomeMobileRepair;
    @BindView(R.id.ll_home_more)
    LinearLayout llHomeMore;

    public static String mContent = "???";

    public static HomeFragment newInstance(String content) {
        HomeFragment fragment = new HomeFragment();
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
        return R.layout.fragment_home ;
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

    @OnClick({R.id.ll_home_more, R.id.ll_home_on_sale, R.id.ll_home_shoujiweixiu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home_more:
//                EventBus.getDefault().post(new PostResult(EventBusTags.SELECET_CLASSIFY));
                // 跳转分类页面
                ((MainActivity)mContext).setTabSelect(1);
                break;
            case R.id.ll_home_shoujiweixiu:
                Intent intent = new Intent(mContext, BusinessListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
