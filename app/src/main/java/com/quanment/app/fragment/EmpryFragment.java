package com.quanment.app.fragment;

import com.quanment.app.R;

public class EmpryFragment extends BaseFragment {

    public static String mContent = "???";

    public static EmpryFragment newInstance(String content) {
        EmpryFragment fragment = new EmpryFragment();
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
        return R.layout.fragment_empry;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
