package com.quanment.app.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.quanment.app.R;
import com.quanment.app.fragment.ClassifyFragment;
import com.quanment.app.fragment.EmpryFragment;
import com.quanment.app.fragment.HomeFragment;
import com.quanment.app.fragment.NewsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.ll_classify)
    LinearLayout llClassify;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
    @BindView(R.id.ll_mine)
    LinearLayout llMine;
    @BindView(R.id.main_bottomtab_layout)
    LinearLayout mainBottomtabLayout;
    @BindView(R.id.vpager)
    ViewPager vpager;
    private MainFragmentAdapter mAdapter;
    public final String[] tabCount = new String[]{"首页", "分类", "消息", "我的"};

    private static final String STATUS_KEY = "status";

    public static final String HOME ="1";
    public static final String CLASSIFY ="2";
    public static final String MESSAGE ="3";
    public static final String MINE ="4";
    private static final String[] STATUS={HOME,CLASSIFY,MESSAGE,MINE};

    @Override
    protected void initData() {
        ButterKnife.bind(this);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setupViews();
        /**检测app版本**/
//        Beta.checkUpgrade(false, true);
    }

    @Override
    protected boolean isBindEventBusHere() {
        return true;
    }

    private void setupViews() {
        vpager.setOffscreenPageLimit(5);
        mAdapter = new MainFragmentAdapter(getSupportFragmentManager());
        vpager.setAdapter(mAdapter);
        vpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        if (getIntent().hasExtra(STATUS_KEY)){
            for (int i=0;i<STATUS.length;i++){
                if (getIntent().getStringExtra(STATUS_KEY).equals(STATUS[1])){
//                    if (LoginMsgHelper.isLogin(mContext)) {
//                        vpager.setCurrentItem(1);
//                        tabSelected(llTuoguan);
//                    } else {
//                        CommonUtil2.goActivity(mContext, LoginActivity.class);
//                    }
                }
            }
        }else{
            vpager.setCurrentItem(0);
            tabSelected(llHome);
        }

    }

    @OnClick({R.id.ll_home, R.id.ll_classify, R.id.ll_message, R.id.ll_mine})
    public void onClcik(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                vpager.setCurrentItem(0);
                tabSelected(llHome);
                break;
            case R.id.ll_classify:
//                if (LoginMsgHelper.isLogin(mContext)) {
                    vpager.setCurrentItem(1);
                    tabSelected(llClassify);
//                } else {
//                    CommonUtil2.goActivity(mContext, LoginActivity.class);
//                }
                break;
            case R.id.ll_message:
                vpager.setCurrentItem(2);
                tabSelected(llMessage);
                break;
            case R.id.ll_mine:
                vpager.setCurrentItem(3);
                tabSelected(llMine);
                break;
        }
    }

    private void tabSelected(LinearLayout linearLayout) {
        llHome.setSelected(false);
        llClassify.setSelected(false);
        llMessage.setSelected(false);
        llMine.setSelected(false);
        linearLayout.setSelected(true);
    }

    public void setTabSelect(int index){
        vpager.setCurrentItem(index);
        if(index == 0){
            tabSelected(llHome);
        }else if(index == 1){
            tabSelected(llClassify);
        }else if(index == 2){
            tabSelected(llMessage);
        }else{
            tabSelected(llMine);
        }
    }

    public class MainFragmentAdapter extends FragmentPagerAdapter {


        private int mCount = tabCount.length;

        public MainFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                return HomeFragment.newInstance(tabCount[position % tabCount.length]);
            } else if (position == 1) {
                return ClassifyFragment.newInstance(tabCount[position % tabCount.length]);
            } else if (position == 2) {
                return NewsFragment.newInstance(tabCount[position % tabCount.length]);
            } else {
                return EmpryFragment.newInstance(tabCount[position % tabCount.length]);
            }

        }

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabCount[position % tabCount.length];
        }

    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), getString(R.string.tips_exit), Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();

            } else {
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
