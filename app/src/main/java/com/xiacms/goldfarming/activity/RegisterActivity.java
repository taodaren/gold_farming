package com.xiacms.goldfarming.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xiacms.goldfarming.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView textLogin = (TextView) findViewById(R.id.text_title_top);
        textLogin.setText("注册");
    }

    public void onRegister(View view) {
        Toast.makeText(this, "register", Toast.LENGTH_SHORT).show();
    }

    public void onSendCode(View view) {
        Toast.makeText(this, "send code", Toast.LENGTH_SHORT).show();
    }
}
