package com.xiacms.goldfarming.net;

import android.content.Context;

import com.xiacms.goldfarming.mode_home.bean.BannerBean;
import com.xiacms.goldfarming.mode_home.bean.ProductDetailsBean;

/**
 * 首页网络访问数据接口
 */

public interface IHomepageModel {
    void loadHomepageData(Context context, OnCompleteListener<ProductDetailsBean[]> listener);
    void loadHomepageBannerData(Context context, OnCompleteListener<BannerBean[]> listener);
}
