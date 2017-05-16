package com.xiacms.goldfarming.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.xiacms.goldfarming.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 加载更多
 */

public class LoadingViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_loading)
    TextView textLoading;

    public LoadingViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void setTextLoading(int loadingString) {
        textLoading.setText(loadingString);
    }
}
