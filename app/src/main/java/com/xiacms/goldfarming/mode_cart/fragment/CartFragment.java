package com.xiacms.goldfarming.mode_cart.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends BaseFragment {
    private RecyclerView recyclerCart;

    @Override
    public View initView() {
        View inflate = View.inflate(mContext, R.layout.fragment_cart, null);

        //初始化分类标题栏
        TextView textTitle = (TextView) inflate.findViewById(R.id.text_title_top);
        textTitle.setText("购物车");
        return inflate;
    }

}
