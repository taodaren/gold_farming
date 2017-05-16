package com.xiacms.goldfarming.net;

import android.content.Context;

import com.xiacms.goldfarming.global.I;
import com.xiacms.goldfarming.mode_type.bean.TypeLeftBean;
import com.xiacms.goldfarming.mode_type.bean.TypeRightBean;
import com.xiacms.goldfarming.utils.OkHttpUtils;

/**
 * 分类界面网络访问实现类
 */

public class MCategoryModel implements ICategoryModel {
    @Override
    public void loadCategoryGroupData(Context context, OnCompleteListener<TypeLeftBean[]> listener) {
        OkHttpUtils<TypeLeftBean[]> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.CATEGORY_GROUP_URL)
                .targetClass(TypeLeftBean[].class)
                .execute(listener);
    }

    @Override
    public void loadCategoryChildData(Context context, int id, String name,
                                      String price, String oldPrice, String imgUrl,
                                      OnCompleteListener<TypeRightBean[]> listener) {
        OkHttpUtils<TypeRightBean[]> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.CATEGORY_CHILD_URL)
                .addParam(I.CategoryChild.ID, String.valueOf(id))
                .addParam(I.CategoryChild.NAME, String.valueOf(name))
                .addParam(I.CategoryChild.PRICE, String.valueOf(price))
                .addParam(I.CategoryChild.OLD_PRICE, String.valueOf(oldPrice))
                .addParam(I.CategoryChild.IMAGE_URL, String.valueOf(imgUrl))
                .targetClass(TypeRightBean[].class)
                .execute(listener);
    }

    @Override
    public void loadChildData(Context context, int parentId, OnCompleteListener<TypeRightBean[]> listener) {
        OkHttpUtils<TypeRightBean[]> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.CATEGORY_CHILD_URL)
                .addParam(I.CategoryChild.PARENT_ID, String.valueOf(parentId))
                .targetClass(TypeRightBean[].class)
                .execute(listener);
    }
}
