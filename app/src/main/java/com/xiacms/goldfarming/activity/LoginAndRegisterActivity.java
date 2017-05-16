package com.xiacms.goldfarming.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.global.MFGT;

public class LoginAndRegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton mBtnBack;
    private Button mBtnRegister, mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_register);
        initView();
        setOnClickListener();
    }

    private void setOnClickListener() {
        mBtnBack.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
    }

    private void initView() {
        mBtnBack = (ImageButton) findViewById(R.id.image_login_back);
        mBtnRegister = (Button) findViewById(R.id.button_register);
        mBtnLogin = (Button) findViewById(R.id.button_login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_login_back:
                MFGT.finishActivity(this);
                break;
            case R.id.button_register:
                MFGT.gotoRegister(this,RegisterActivity.class);
                break;
            case R.id.button_login:
                MFGT.gotoLogin(this, LoginActivity.class);
                break;
        }
    }

}
