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

    @BindView(R.id.ll_home_zhusu)
    LinearLayout mHomeHotel;
    @BindView(R.id.ll_home_jianshen)
    LinearLayout mHomeFitness;
    @BindView(R.id.ll_home_meifa)
    LinearLayout mHomeMeifa;
    @BindView(R.id.ll_home_meirong)
    LinearLayout mHomeMeirong;
    @BindView(R.id.ll_home_meijia)
    LinearLayout mHomeMeijia;
    @BindView(R.id.ll_home_meishi)
    LinearLayout mHomeMeishi;
    @BindView(R.id.ll_home_yifu)
    LinearLayout mHomeClothes;
    @BindView(R.id.ll_home_dayinpaizhao)
    LinearLayout mHomeDayin;
    @BindView(R.id.ll_home_shoujimaimai)
    LinearLayout mHomeMobileSale;
    @BindView(R.id.ll_home_xianhua)
    LinearLayout mHomeFlower;
    @BindView(R.id.ll_home_shucai)
    LinearLayout mHomeVegetables;
    @BindView(R.id.ll_home_shuiguolei)
    LinearLayout mHomeFruits;
    @BindView(R.id.ll_home_roulei)
    LinearLayout mHomeMeat;
    @BindView(R.id.ll_home_yulei)
    LinearLayout mHomeFish;
    @BindView(R.id.ll_home_haixianlei)
    LinearLayout mHomeHaixian;
    @BindView(R.id.ll_home_guanggaozhizuo)
    LinearLayout mHomeAds;
    @BindView(R.id.ll_home_peijukaisuo)
    LinearLayout mHomePeiju;
    @BindView(R.id.ll_home_dianqiweixiu)
    LinearLayout mHomeEquipmentRepair;
    @BindView(R.id.ll_home_shoujiweixiu)
    LinearLayout mHomeMobileRepair;

    @BindView(R.id.ll_home_more)
    LinearLayout mHomeMore;

    @BindView(R.id.ll_home_on_sale)
    LinearLayout mHomeOnSale;

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
        ImmersionBar.with(this).keyboardEnable(true).init();
    }

    @OnClick({R.id.ll_home_zhusu, R.id.ll_home_jianshen, R.id.ll_home_meifa,
            R.id.ll_home_meirong, R.id.ll_home_meijia, R.id.ll_home_meishi,
            R.id.ll_home_yifu, R.id.ll_home_dayinpaizhao, R.id.ll_home_shoujimaimai,
            R.id.ll_home_xianhua, R.id.ll_home_shucai, R.id.ll_home_shuiguolei,
            R.id.ll_home_roulei, R.id.ll_home_yulei, R.id.ll_home_haixianlei,
            R.id.ll_home_guanggaozhizuo, R.id.ll_home_peijukaisuo, R.id.ll_home_dianqiweixiu,
            R.id.ll_home_shoujiweixiu, R.id.ll_home_more, R.id.ll_home_on_sale})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.ll_home_zhusu:
                intent = new Intent(mContext, BusinessListActivity.class);
                break;
            case R.id.ll_home_jianshen:
            case R.id.ll_home_meifa:
            case R.id.ll_home_meirong:
            case R.id.ll_home_meijia:
            case R.id.ll_home_meishi:
            case R.id.ll_home_yifu:
            case R.id.ll_home_dayinpaizhao:
            case R.id.ll_home_shoujimaimai:
            case R.id.ll_home_xianhua:
            case R.id.ll_home_shucai:
            case R.id.ll_home_shuiguolei:
            case R.id.ll_home_roulei:
            case R.id.ll_home_yulei:
            case R.id.ll_home_haixianlei:
            case R.id.ll_home_guanggaozhizuo:
            case R.id.ll_home_peijukaisuo:
            case R.id.ll_home_dianqiweixiu:
            case R.id.ll_home_shoujiweixiu:
                intent = new Intent(mContext, BusinessListActivity.class);
                break;
            case R.id.ll_home_more:
//                EventBus.getDefault().post(new PostResult(EventBusTags.SELECET_CLASSIFY));
                // 跳转分类页面
                ((MainActivity)mContext).setTabSelect(1);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
