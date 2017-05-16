package com.xiacms.goldfarming.mode_type.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.activity.ProductDetailsActivity;
import com.xiacms.goldfarming.global.MFGT;
import com.xiacms.goldfarming.mode_type.bean.TypeRightBean;
import com.xiacms.goldfarming.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 分类右侧商品适配器
 */

public class TypeRightAdapter extends RecyclerView.Adapter<TypeRightAdapter.ChildViewHolder> {
    private Context mContext;
    private List<TypeRightBean> rightBeanList;


    public TypeRightAdapter(Context mContext, List<TypeRightBean> rightBeanList) {
        this.mContext = mContext;
        this.rightBeanList = rightBeanList;
    }

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tpye_right, parent, false);
        return new ChildViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ChildViewHolder holder, final int position) {
        TypeRightBean rightBean = rightBeanList.get(position);
        ImageLoader.downloadImg(mContext, holder.imageUrl, rightBean.getImageUrl());
        for (int i = 0; i < rightBeanList.size(); i++) {
            holder.textProName.setText(rightBean.getName());
            holder.textPrice.setText(rightBean.getPrice());
            holder.textOldPrice.setText(rightBean.getOldPrice());
            holder.textOldPrice.setPaintFlags(holder.textOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);// 为商品原价添加删除线
            holder.rlRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFGT.gotoProductDetails(mContext, ProductDetailsActivity.class);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return rightBeanList.size();
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_category_xiang_qing)
        ImageView imageUrl;               // 商品图片
        @BindView(R.id.text_fl_title)
        TextView textProName;             // 商品名称
        @BindView(R.id.text_fl_jia_ge)
        TextView textPrice;               // 商品价格
        @BindView(R.id.text_fl_yuan_jia)
        TextView textOldPrice;            // 商品原价
        @BindView(R.id.layout_item_type_right)
        RelativeLayout rlRight;


        public ChildViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
