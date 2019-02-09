package com.quanment.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.quanment.app.R;
import com.quanment.app.model.NewsListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Family on 2019/2/8
 */
public class NewsChatRecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    private Context context;
    private List<NewsListBean> beanList;

    public NewsChatRecyclerViewAdapter(Context context, List<NewsListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (beanList.size() != 0) {
            final NewsListBean bean = beanList.get(position);
            ViewHolder vholder = (ViewHolder) holder;
//            vholder.mNewsName.setText(bean.getBusinessName());
//            vholder.mNewsContent.setText(bean.getBusinessDistance());
//            vholder.mNewsTime.setText(bean.getBusinessPrices());
            vholder.mNewsDetails.setOnClickListener(this);
            vholder.mNewsDetails.setTag(position);
        }
    }

    @Override
    public int getItemCount() {
        return beanList.size();
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

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.news_head_icon)
        ImageView mNewsHeadIcon;
        @BindView(R.id.news_name)
        TextView mNewsName;
        @BindView(R.id.news_content)
        TextView mNewsContent;
        @BindView(R.id.news_time)
        TextView mNewsTime;
        @BindView(R.id.news_details)
        LinearLayout mNewsDetails;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
