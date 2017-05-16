package com.xiacms.goldfarming.mode_home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.mode_home.bean.HomeJumpBean;

import java.util.List;

/**
 * 首页分类跳转
 */

public class HomeCateAdapter extends BaseAdapter {
    private Context context;
    private List<HomeJumpBean> beanList;

    public HomeCateAdapter(Context context, List<HomeJumpBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public int getCount() {
        return beanList == null ? 0 : beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.layout_channel_info, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /*装配数据*/
        HomeJumpBean bean = beanList.get(position);
        /*使用Glide加载图片*/
        Glide.with(context)
                .load(bean.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.imageView);
        /*设置文本*/
        viewHolder.textView.setText(bean.getName());

        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;

        ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.image_cate_jump);
            textView = (TextView) view.findViewById(R.id.text_cate_jump);
        }
    }

}
