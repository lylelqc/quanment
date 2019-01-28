package com.quanment.app.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.quanment.app.R;
import com.quanment.app.utils.StatusBarUtils;
import com.quanment.app.view.FadingScrollView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class BusinessDetailsActivity extends BaseActivity {

    @BindView(R.id.toobar)
    FrameLayout mToobar;
    @BindView(R.id.btn_main_back)
    LinearLayout mBack;
    @BindView(R.id.tv_main_title)
    TextView mTitle;

    @BindView(R.id.fading_scroll_view)
    FadingScrollView fadingScrollView;
    @BindView(R.id.nac_layout)
    View layout;
    @BindView(R.id.banner)
    Banner banner;

    private List images;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_business_details;
    }

    @Override
    protected void initData() {
        images = new ArrayList<>();
        images.add(R.mipmap.business_details_pic1);
        images.add(R.mipmap.business_details_pic2);
        images.add(R.mipmap.business_details_pic3);
    }

    @Override
    protected void initView() {
        mTitle.setText(getString(R.string.business_details));
        StatusBarUtils.setStatusBarColor(this, R.color.app_bottom_color);

//        mImmersionBar.statusBarColor(R.color.app_bottom_color);
//                .titleBar(mToobar)
//                .init();

        layout.setAlpha(0);
        fadingScrollView.setFadingView(layout);
        fadingScrollView.setFadingHeightView(banner);
        initBanner();
    }

    private void initBanner() {
        //设置图片加载器
        banner.setImageLoader(new MyImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(5000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }


    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    private class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }
    }

    @OnClick({R.id.btn_main_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_main_back:
                finish();
                break;
        }
    }
}
