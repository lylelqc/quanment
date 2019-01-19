package com.quanment.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.quanment.app.R;
import com.quanment.app.model.BusinessListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessListRecylerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private Context context;
    private List<BusinessListBean> beanList;

    public BusinessListRecylerViewAdapter(Context context, List<BusinessListBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_business_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (beanList.size() != 0) {
            final BusinessListBean bean = beanList.get(position);
            ViewHolder vholder = (ViewHolder) holder;
            vholder.mBusinessId.setText((position + 1) + "");
            vholder.mBusinessName.setText(bean.getBusinessName());
            vholder.mBusinessDistance.setText(bean.getBusinessDistance());
            vholder.mBusinessPrices.setText(bean.getBusinessPrices());
            vholder.mBusinessSaleCount.setText(bean.getBusinessSaleCount());

            if(position < 2){
                if(position == 0){
                    vholder.mBusinessDetails.setBackgroundResource(R.mipmap.business_bg_blue);
                }else{
                    vholder.mBusinessDetails.setBackgroundResource(R.mipmap.business_bg_yellow);
                }
                vholder.mBusinessName.getPaint().setFakeBoldText(true);
                vholder.mBusinessPrices.getPaint().setFakeBoldText(true);
            }

            vholder.mBusinessNext.setOnClickListener(this);
            vholder.mBusinessNext.setTag(position);
            vholder.mBusinessDetails.setOnClickListener(this);
            vholder.mBusinessDetails.setTag(position);
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
        @BindView(R.id.business_id1)
        TextView mBusinessId;
        @BindView(R.id.business_picture)
        ImageView mBusinessPic;
        @BindView(R.id.business_name)
        TextView mBusinessName;
        @BindView(R.id.business_distance)
        TextView mBusinessDistance;
        @BindView(R.id.business_prices)
        TextView mBusinessPrices;
        @BindView(R.id.business_sale_count)
        TextView mBusinessSaleCount;
        @BindView(R.id.business_next)
        LinearLayout mBusinessNext;
        @BindView(R.id.business_details)
        LinearLayout mBusinessDetails;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
