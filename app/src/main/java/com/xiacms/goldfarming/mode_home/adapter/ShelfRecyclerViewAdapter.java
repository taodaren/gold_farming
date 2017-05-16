package com.xiacms.goldfarming.mode_home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.mode_home.bean.HomeShelfBean;

import java.util.List;

/**
 * 金品货架适配器
 */

public class ShelfRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<HomeShelfBean> shelfBeanList;

    public ShelfRecyclerViewAdapter(Context mContext, List<HomeShelfBean> mShelfBean) {
        this.mContext = mContext;
        this.shelfBeanList = mShelfBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShelfViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_shelf_info, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ShelfViewHolder shelfViewHolder = (ShelfViewHolder) holder;
        shelfViewHolder.setData(position);
    }

    @Override
    public int getItemCount() {
        return shelfBeanList.size();
    }

    class ShelfViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        private ImageView imageShelf;
        private TextView textTitle;
        private TextView textPrice;
        private TextView textOldPrice;
        private TextView textDiscount;//折扣
        private TextView textSubplus;//剩余

        public ShelfViewHolder(View itemView) {
            super(itemView);
            imageShelf = (ImageView) itemView.findViewById(R.id.image_homepage_shelf);
            textTitle = (TextView) itemView.findViewById(R.id.text_shelf_title);
            textPrice = (TextView) itemView.findViewById(R.id.text_shelf_price);
            textOldPrice = (TextView) itemView.findViewById(R.id.text_shelf_old_price);
            textDiscount = (TextView) itemView.findViewById(R.id.image_homepage_num);
            textSubplus = (TextView) itemView.findViewById(R.id.text_home_subplus);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.rl_shelf);
        }

        public void setData(final int position) {
            HomeShelfBean shelfBean = shelfBeanList.get(position);
            textTitle.setText(shelfBean.getProductBase().getName());
            textPrice.setText(shelfBean.getProductBase().getPrice());
            textOldPrice.setText(shelfBean.getProductBase().getOldPrice());
            textDiscount.setText(String.valueOf(shelfBean.getDiscount()));
            textSubplus.setText(String.valueOf(shelfBean.getSurplus()));
            Glide.with(mContext)
                    .load(shelfBean.getProductBase().getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageShelf);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "position" + position, Toast.LENGTH_SHORT).show();
                    if (onShelfRecyclerView != null) {
                        onShelfRecyclerView.onItemClick(position);
                    }
                }
            });
        }
    }

    /**
     * 监听器
     */
    public interface OnShelfRecyclerView {
        //当某条点击时候回掉
        void onItemClick(int position);
    }

    private OnShelfRecyclerView onShelfRecyclerView;

    /**
     * 设置item监听
     */
    public void setOnShelfRecyclerView(OnShelfRecyclerView onShelfRecyclerView) {
        this.onShelfRecyclerView = onShelfRecyclerView;
    }

}

