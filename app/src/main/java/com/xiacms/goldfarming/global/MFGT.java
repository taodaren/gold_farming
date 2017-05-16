package com.xiacms.goldfarming.global;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.activity.ProductDetailsActivity;

/**
 * 活动跳转类：Move_From_Go_To
 */

public class MFGT {

    public static void startActivity(Activity activity, Class<?> cls) {
        activity.startActivity(new Intent(activity,cls));
    }

    public static void finishActivity(Activity activity) {
        activity.finish();
    }

    /**
     * Fragment跳转到商品详情
     **/
    public static void gotoProductDetails(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    /**
     * 首页标题跳转到消息界面
     **/
    public static void gotoTitleMsg(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    /**
     * 跳转到登录界面
     **/
    public static void gotoLogin(Activity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }

    /**
     * 跳转到注册界面
     **/
    public static void gotoRegister(Activity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }

    /**
     * 跳转到商品详情
     **/
    public static void gotoProductDetails(Context activity, int proId) {
        startActivityForResult((Activity) activity,
                new Intent(activity, ProductDetailsActivity.class)
                        .putExtra(I.Product.PRODUCT_ID, proId), I.REQUEST_CODE_COLLECT);

    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
        activity.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

}
