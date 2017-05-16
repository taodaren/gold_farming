package com.xiacms.goldfarming.mode_home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.mode_type.bean.TypeLeftBean;

import java.util.List;

/**
 * 首页跳转分类适配器
 */

public class BatAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<TypeLeftBean> beanList;

    public BatAdapter(Context context, List<TypeLeftBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CateJumpViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_cate_jump, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CateJumpViewHolder viewHolder = (CateJumpViewHolder) holder;
        viewHolder.setData(position);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    private class CateJumpViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public CateJumpViewHolder(View itemView) {
            super(itemView);
            itemView = itemView.findViewById(R.id.homepage_cate_jump);
        }

        public void setData(int position) {
            TypeLeftBean typeLeftBean = beanList.get(position);
            // 使用 Glide 加载图片
            Glide.with(context)
                    .load(typeLeftBean.getImageUrl())
                    .into(imageView);
        }
    }
}
