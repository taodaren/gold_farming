package com.xiacms.goldfarming.net;

import android.content.Context;

import com.xiacms.goldfarming.mode_type.bean.TypeRightBean;
import com.xiacms.goldfarming.mode_type.bean.TypeLeftBean;

/**
 * 分类界面网络访问数据接口
 */

public interface ICategoryModel {
    void loadCategoryGroupData(Context context, OnCompleteListener<TypeLeftBean[]> listener);

    void loadCategoryChildData(Context context, int id, String name, String price, String oldPrice, String imgUrl,
                               OnCompleteListener<TypeRightBean[]> listener);

    void loadChildData(Context context, int parentId, OnCompleteListener<TypeRightBean[]> listener);
}
