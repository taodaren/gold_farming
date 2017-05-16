package com.xiacms.goldfarming.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xiacms.goldfarming.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView textLogin = (TextView) findViewById(R.id.text_title_top);
        textLogin.setText("登录");
    }

    public void onLogin(View view) {
        Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
    }
}
