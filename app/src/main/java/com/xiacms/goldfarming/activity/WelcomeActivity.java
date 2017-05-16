package com.xiacms.goldfarming.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.global.MFGT;

/**
 * 欢迎界面
 */

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // 两秒钟进入MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 启动MainActivity主页面，这段代码是在主线程执行
                MFGT.startActivity(WelcomeActivity.this, MainActivity.class);
                // 关闭当前页面（结束WelcomeActivity）
                MFGT.finishActivity(WelcomeActivity.this);
            }
        }, 2000);
    }
}
