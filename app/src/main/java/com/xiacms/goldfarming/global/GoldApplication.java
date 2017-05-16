package com.xiacms.goldfarming.global;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.TimeUnit;

import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.OkHttpClient;

/**
 * Application 类:用于全局调用
 */

public class GoldApplication extends Application {
    private static GoldApplication instance;

    public static Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttpClient();// 初始化OkHttpUtils
        instance = this;
    }

    /** 初始化OkHttpUtils*/
    private void initOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)// 链接超时
                .readTimeout(10000L,TimeUnit.MILLISECONDS)// 读取超时
                .build();// 其它配置
        OkHttpUtils.initClient(okHttpClient);
    }
}
