package com.quanment.app.fragment;

import com.quanment.app.R;

public class HomeFragment extends BaseFragment{


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
