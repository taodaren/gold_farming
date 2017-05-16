package com.xiacms.goldfarming.mode_home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.global.I;
import com.xiacms.goldfarming.mode_home.bean.ProductDetailsBean;
import com.xiacms.goldfarming.view.LoadingViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页 金品货架适配器
 */

public class Bat_HomepageShelfAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<ProductDetailsBean> productDetailsBeanList;
    boolean isMore; // 是否有更多

//    private int totalCount = 0;

    public Bat_HomepageShelfAdapter(Context context) {
        this.context = context;
    }

    public Bat_HomepageShelfAdapter(Context context, List<ProductDetailsBean> productDetailsBeanList, boolean isMore) {
        this.context = context;
        this.productDetailsBeanList = productDetailsBeanList;
        this.isMore = isMore;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    private int getLoadingString() {
        return isMore ? R.string.load_more : R.string.no_more;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == I.TYPE_LOADING) {
            viewHolder = new LoadingViewHolder(View.inflate(context, R.layout.item_loading, null));
        } else {
            viewHolder = new ProShelfViewHolder(View.inflate(context, R.layout.item_home_shelf_item, null));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == I.TYPE_LOADING) {
            LoadingViewHolder viewHolder = (LoadingViewHolder) holder;
            viewHolder.setTextLoading(getLoadingString());
            return;
        }
//        ProShelfViewHolder viewHolder = (ProShelfViewHolder) holder;
//        final ProductDetailsBean bean = productDetailsBeanList.get(position);
//        viewHolder.textShelfTitle.setText(bean.getName());
//        viewHolder.textShelfPrice.setText(bean.getPrice());
//        viewHolder.textShelfOldPrice.setText(bean.getOldPrice());
//        viewHolder.textShengYu.setText("9527");// 假数据，待数据
//        ImageLoader.downloadImg(context, viewHolder.imageHomepageShelf, bean.getImageUrl());
////        ImageLoader.downloadImg(context, viewHolder.imageHomepageZheKou, bean.getImgDiscount());
//        viewHolder.imageHomepageZheKou.setImageResource(R.drawable.zhe_kou);// 假数据，待数据
//        /* 点击商品跳转到商品详情 */
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MFGT.gotoProductDetails(context, bean.getId());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return productDetailsBeanList != null ? productDetailsBeanList.size() + 1 : 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return I.TYPE_LOADING;
        }
        return I.TYPE_ITEM;
    }

    static class ProShelfViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_homepage_shelf)
        ImageView imageHomepageShelf;
        @BindView(R.id.text_shelf_title)
        TextView textShelfTitle;
        @BindView(R.id.text_shelf_price)
        TextView textShelfPrice;
        @BindView(R.id.text_shelf_old_price)
        TextView textShelfOldPrice;
        @BindView(R.id.image_homepage_num)
        ImageView imageHomepageZheKou;
        @BindView(R.id.text_sheng_yu)
        TextView textShengYu;

        public ProShelfViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
