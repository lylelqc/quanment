package com.quanment.app.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.quanment.app.R;

import butterknife.BindView;

public class HomeFragment extends BaseFragment{

    @BindView(R.id.ll_home_on_sale)
    LinearLayout llHomeOnSale;
    @BindView(R.id.status_view)
    View status;

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
}
