package com.xiacms.goldfarming.mode_type.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.mode_type.bean.TypeLeftBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类左侧适配器
 */

public class TypeLeftAdapter extends BaseAdapter {
    private Context mContext;
    private List<TypeLeftBean> leftBeanList;
    private int mSelect = 0;// 当前被选中的行索引

    public TypeLeftAdapter(Context mContext, List<TypeLeftBean> list) {
        this.mContext = mContext;
        this.leftBeanList = list;
    }

    @Override
    public int getCount() {
        if (leftBeanList == null) return 0;
        return leftBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        if (leftBeanList == null) return null;
        return leftBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        if (leftBeanList == null) return -1;
        return leftBeanList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // 使用自定义的 item_type_left 作为 Layout
            convertView = View.inflate(mContext, R.layout.item_type_left, null);
            // 使用减少 findView 的次数
            holder = new ViewHolder();
            holder.groupName = (TextView) convertView.findViewById(R.id.text_category_group);
            holder.relativeLayout = (RelativeLayout) convertView.findViewById(R.id.layout_item_type_left);
            holder.rlLine = (RelativeLayout) convertView.findViewById(R.id.rl_type_left);

            // 设置标记
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.groupName.setText(leftBeanList.get(position).getName());

        if (mSelect==position){
            //选中
            holder.groupName.setTextColor(Color.parseColor("#45a73a"));
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#efeff0"));
            holder.rlLine.setVisibility(View.VISIBLE);
        }else {
            holder.groupName.setTextColor(Color.parseColor("#323437"));
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.rlLine.setVisibility(View.GONE);

        }

        return convertView;
    }

    public void changeSelected(int position) {
        if (position != mSelect) {
            mSelect = position;
            notifyDataSetChanged();
        }
    }

    class ViewHolder {
        RelativeLayout relativeLayout;
        TextView groupName;
        RelativeLayout rlLine;
    }

}
