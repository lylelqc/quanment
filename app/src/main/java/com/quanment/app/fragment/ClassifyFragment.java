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
    @BindView(R.id.ll_classify_jianshen)
    LinearLayout mClassifyFitness;
    @BindView(R.id.ll_classify_meifa)
    LinearLayout mClassifyMeifa;
    @BindView(R.id.ll_classify_meirong)
    LinearLayout mClassifyMeirong;
    @BindView(R.id.ll_classify_meijia)
    LinearLayout mClassifyMeijia;
    @BindView(R.id.ll_classify_meishi)
    LinearLayout mClassifyMeishi;
    @BindView(R.id.ll_classify_yifu)
    LinearLayout mClassifyClothes;
    @BindView(R.id.ll_classify_dayinpaizhao)
    LinearLayout mClassifyDayin;
    @BindView(R.id.ll_classify_shoujimaimai)
    LinearLayout mClassifyMobileSale;
    @BindView(R.id.ll_classify_xianhua)
    LinearLayout mClassifyFlower;
    @BindView(R.id.ll_classify_shucai)
    LinearLayout mClassifyVegetables;
    @BindView(R.id.ll_classify_shuiguolei)
    LinearLayout mClassifyFruits;
    @BindView(R.id.ll_classify_roulei)
    LinearLayout mClassifyMeat;
    @BindView(R.id.ll_classify_yulei)
    LinearLayout mClassifyFish;
    @BindView(R.id.ll_classify_haixianlei)
    LinearLayout mClassifyHaixian;
    @BindView(R.id.ll_classify_guanggaozhizuo)
    LinearLayout mClassifyAds;
    @BindView(R.id.ll_classify_peijukaisuo)
    LinearLayout mClassifyPeiju;
    @BindView(R.id.ll_classify_dianqiweixiu)
    LinearLayout mClassifyEquipmentRepair;
    @BindView(R.id.ll_classify_shoujiweixiu)
    LinearLayout mClassifyMobileRepair;
    @BindView(R.id.ll_classify_jiaoyupeixun)
    LinearLayout mClassifyEducation;
    @BindView(R.id.ll_classify_kongtiaoweixiu)
    LinearLayout mClassifyKongTiao;
    @BindView(R.id.ll_classify_diannaoweixiu)
    LinearLayout mClassifyComputerRepair;
    @BindView(R.id.ll_classify_yanjingdian)
    LinearLayout mClassifyGlasses;
    @BindView(R.id.ll_classify_wujindian)
    LinearLayout mClassifyHardware;
    @BindView(R.id.ll_classify_menchuangzhizuo)
    LinearLayout mClassifyMenChuang;
    @BindView(R.id.ll_classify_kuaidi)
    LinearLayout mClassifyKuaidi;
    @BindView(R.id.ll_classify_wuliu)
    LinearLayout mClassifyWuliu;
    @BindView(R.id.ll_classify_hunshasheying)
    LinearLayout mClassifyHunsha;
    @BindView(R.id.ll_classify_qichebaoyang)
    LinearLayout mClassifyCar;
    @BindView(R.id.ll_classify_gongshangzhuce)
    LinearLayout mClassifyBusiness;

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
        ImmersionBar.with(this).keyboardEnable(true).init();
    }


    @OnClick({R.id.ll_classify_zhusu,R.id.ll_classify_jianshen, R.id.ll_classify_meifa,
            R.id.ll_classify_meirong, R.id.ll_classify_meijia, R.id.ll_classify_meishi,
            R.id.ll_classify_yifu, R.id.ll_classify_dayinpaizhao, R.id.ll_classify_shoujimaimai,
            R.id.ll_classify_xianhua, R.id.ll_classify_shucai, R.id.ll_classify_shuiguolei,
            R.id.ll_classify_roulei, R.id.ll_classify_yulei, R.id.ll_classify_haixianlei,
            R.id.ll_classify_guanggaozhizuo, R.id.ll_classify_peijukaisuo, R.id.ll_classify_dianqiweixiu,
            R.id.ll_classify_shoujiweixiu, R.id.ll_classify_jiaoyupeixun, R.id.ll_classify_kongtiaoweixiu,
            R.id.ll_classify_diannaoweixiu, R.id.ll_classify_yanjingdian, R.id.ll_classify_wujindian,
            R.id.ll_classify_menchuangzhizuo, R.id.ll_classify_kuaidi, R.id.ll_classify_wuliu,
            R.id.ll_classify_hunshasheying, R.id.ll_classify_qichebaoyang, R.id.ll_classify_gongshangzhuce})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.ll_classify_zhusu:
                intent = new Intent(mContext, BusinessListActivity.class);
                break;
            case R.id.ll_classify_jianshen:
            case R.id.ll_classify_meifa:
            case R.id.ll_classify_meirong:
            case R.id.ll_classify_meijia:
            case R.id.ll_classify_meishi:
            case R.id.ll_classify_yifu:
            case R.id.ll_classify_dayinpaizhao:
            case R.id.ll_classify_shoujimaimai:
            case R.id.ll_classify_xianhua:
            case R.id.ll_classify_shucai:
            case R.id.ll_classify_shuiguolei:
            case R.id.ll_classify_roulei:
            case R.id.ll_classify_yulei:
            case R.id.ll_classify_haixianlei:
            case R.id.ll_classify_guanggaozhizuo:
            case R.id.ll_classify_peijukaisuo:
            case R.id.ll_classify_dianqiweixiu:
            case R.id.ll_classify_shoujiweixiu:
            case R.id.ll_classify_jiaoyupeixun:
            case R.id.ll_classify_kongtiaoweixiu:
            case R.id.ll_classify_diannaoweixiu:
            case R.id.ll_classify_yanjingdian:
            case R.id.ll_classify_wujindian:
            case R.id.ll_classify_menchuangzhizuo:
            case R.id.ll_classify_kuaidi:
            case R.id.ll_classify_wuliu:
            case R.id.ll_classify_hunshasheying:
            case R.id.ll_classify_qichebaoyang:
            case R.id.ll_classify_gongshangzhuce:
                intent = new Intent(mContext, BusinessListActivity.class);
                break;
        }

        if(intent != null){
            startActivity(intent);
        }
    }
}
