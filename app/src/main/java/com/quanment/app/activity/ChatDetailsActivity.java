package com.quanment.app.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.quanment.app.Commom;
import com.quanment.app.R;
import com.quanment.app.adapter.ChatDetailsRecyclerViewAdapter;
import com.quanment.app.model.ChatDetailsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Family on 2019/2/8
 */
public class ChatDetailsActivity extends BaseActivity {

    @BindView(R.id.btn_main_back)
    LinearLayout mReturn;
    @BindView(R.id.tv_main_title)
    TextView mTitle;
    @BindView(R.id.ll_right)
    LinearLayout mChatDetailsShop;
    @BindView(R.id.recycler_view)
    RecyclerView mChatDetailsListView;
    private List<ChatDetailsBean> mResultList = new ArrayList<>();
    private ChatDetailsRecyclerViewAdapter mAdapter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_chat_details;
    }

    @Override
    protected void initData() {

        for(int i = 0; i < 6; i++){
            ChatDetailsBean bean = new ChatDetailsBean();
            bean.setMsgContent("哈哈，你好啊"+i);
            bean.setMsgTime("");
            bean.setMsgType(i % 2  == 0 ? Commom.MESSAGE_TYPE_LEFT : Commom.MESSAGE_TYPE_RIGHT);
            mResultList.add(bean);
        }

    }

    @Override
    protected void initView() {
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        String chatName = getIntent().getExtras().getString("ChatName");
        mTitle.setText(chatName);

        refreshRecyclerView();

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    private void refreshRecyclerView() {

        mAdapter = new ChatDetailsRecyclerViewAdapter(mContext, mResultList);
        mChatDetailsListView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mChatDetailsListView.setLayoutManager(layoutManager);
    }
}
