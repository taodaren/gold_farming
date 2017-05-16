package com.xiacms.goldfarming.net;

import android.content.Context;

import com.xiacms.goldfarming.global.I;
import com.xiacms.goldfarming.mode_home.bean.BannerBean;
import com.xiacms.goldfarming.mode_home.bean.ProductDetailsBean;
import com.xiacms.goldfarming.utils.OkHttpUtils;

/**
 * Created by Administrator on 2017/5/3.
 */

public class MHomepageModel implements IHomepageModel {
    @Override
    public void loadHomepageData(Context context, OnCompleteListener<ProductDetailsBean[]> listener) {
        OkHttpUtils<ProductDetailsBean[]> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.HOMEPAGE_GOLD_SHELF)
                .targetClass(ProductDetailsBean[].class)
                .execute(listener);
    }

    @Override
    public void loadHomepageBannerData(Context context, OnCompleteListener<BannerBean[]> listener) {
        OkHttpUtils<BannerBean[]> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.HOMEPAGE_BANNER_IMG)
                .targetClass(BannerBean[].class)
                .execute(listener);
    }
}
