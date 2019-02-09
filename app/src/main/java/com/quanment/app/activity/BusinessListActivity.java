package com.quanment.app.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.quanment.app.R;
import com.quanment.app.adapter.BusinessListRecylerViewAdapter;
import com.quanment.app.model.BusinessListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class BusinessListActivity extends BaseActivity implements BusinessListRecylerViewAdapter.OnItemClickListener {

    @BindView(R.id.btn_main_back)
    LinearLayout mBack;
    @BindView(R.id.tv_main_title)
    TextView mTitle;
    @BindView(R.id.business_list_rv)
    RecyclerView mBusinessRecyclerView;

    private List<BusinessListBean> mResultList = new ArrayList<>();
    private BusinessListRecylerViewAdapter mAdapter;


    @Override
    protected int setLayoutId() {
        return R.layout.activity_business_list;
    }

    @Override
    protected void initData() {
        String type = getIntent().getExtras().getString("type");

        if(type.equals("hotel")){
            for(int i = 0; i< 4; i++){
                BusinessListBean bean = new BusinessListBean();
                bean.setBusinessName("广州国际休闲旅游酒店"+(i+1));
                bean.setBusinessDistance((100*(i+1))+"");
                bean.setBusinessPrices((50*(i+1))+"");
                bean.setBusinessSaleCount((50*i+100)+"");
                mResultList.add(bean);
            }
        }else{
            for(int i = 0; i< 3; i++){
                BusinessListBean bean = new BusinessListBean();
                bean.setBusinessName("******");
                bean.setBusinessDistance("0");
                bean.setBusinessPrices("0.0");
                bean.setBusinessSaleCount("0");
                mResultList.add(bean);
            }
        }

        refreshListView();
    }

    @Override
    protected void initView() {
        mTitle.setText(getString(R.string.business));
        mImmersionBar.titleBar(R.id.ll_comm_layout).init();
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    //初始化适配器
    public void refreshListView() {
        mAdapter = new BusinessListRecylerViewAdapter(mContext, mResultList);
        mBusinessRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mAdapter.setOnItemClickListener(this);
        mBusinessRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onItemClick(View view, int position) {
        startActivityWithoutExtras(BusinessDetailsActivity.class);
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
