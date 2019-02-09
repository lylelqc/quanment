package com.quanment.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.quanment.app.Commom;
import com.quanment.app.R;
import com.quanment.app.model.ChatDetailsBean;
import com.quanment.app.model.NewsListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Family on 2019/2/8
 */
public class ChatDetailsRecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private Context context;
    private List<ChatDetailsBean> beanList;

    public ChatDetailsRecyclerViewAdapter(Context context, List<ChatDetailsBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == Commom.MESSAGE_TYPE_LEFT){
            View view = LayoutInflater.from(context).inflate(R.layout.item_chat_details_left, parent, false);
            return new LeftViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_chat_details_right, parent, false);
            return new LeftViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (beanList.size() != 0) {
            LeftViewHolder viewHolder = (LeftViewHolder) holder;
            final ChatDetailsBean bean = beanList.get(position);
            viewHolder.mChatDetailsTime.setText(bean.getMsgTime());
            viewHolder.mChatDetailsContent.setText(bean.getMsgContent());
        }
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        ChatDetailsBean bean = beanList.get(position);
        if(bean.getMsgType() == 1){
            return Commom.MESSAGE_TYPE_LEFT;
        }else{
            return Commom.MESSAGE_TYPE_RIGHT;
        }
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    class LeftViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.chat_details_time)
        TextView mChatDetailsTime;
        @BindView(R.id.chat_details_head_icon)
        ImageView mChatDetailsHeadIcon;
        @BindView(R.id.chat_details_content)
        TextView mChatDetailsContent;

        public LeftViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

//    class RightViewHolder extends RecyclerView.ViewHolder {
//
//        @BindView(R.id.chat_details_time)
//        TextView mChatDetailsTime;
//        @BindView(R.id.chat_details_head_icon)
//        ImageView mChatDetailsHeadIcon;
//        @BindView(R.id.chat_details_content)
//        TextView mChatDetailsContent;
//
//        public RightViewHolder(View view) {
//            super(view);
//            ButterKnife.bind(this, view);
//        }
//    }
}
