package com.quanment.app.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;
import com.quanment.app.R;
import com.quanment.app.activity.ChatDetailsActivity;
import com.quanment.app.adapter.NewsChatRecyclerViewAdapter;
import com.quanment.app.model.NewsListBean;
import com.quanment.app.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Family on 2019/2/8
 */
public class NewsFragment extends BaseFragment implements NewsChatRecyclerViewAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView mChatListView;

    private List<NewsListBean> mResultList = new ArrayList<>();

    public static String mContent = "???";
    private NewsChatRecyclerViewAdapter mAdapter;

    public static NewsFragment newInstance(String content) {
        NewsFragment fragment = new NewsFragment();
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

        for(int i = 0; i < 10; i++){
            NewsListBean bean = new NewsListBean();
            mResultList.add(bean);
        }

        refreshView();

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_news;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected void initImmersionBar() {
        ImmersionBar.with(this).titleBar(R.id.ll_comm_layout)
//                .statusBarColor(R.color.app_bottom_color)
                .keyboardEnable(true).init();
    }

    private void refreshView(){
        mAdapter = new NewsChatRecyclerViewAdapter(mContext, mResultList);
        mChatListView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mChatListView.setLayoutManager(layoutManager);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        AppUtils.goActivity(mContext, ChatDetailsActivity.class, bundle);
    }
}
