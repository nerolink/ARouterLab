package com.nerolink.arouterlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Date;

@Route(path = "/test/main")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.btn_login);
        Button btnEmpty = findViewById(R.id.btn_empty);
        btnEmpty.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            ARouter.getInstance().build("/test/login").navigation();
        } else if (v.getId() == R.id.btn_empty) {
            ARouter.getInstance().build("/test/empty")
                    .withString("name", "nero")
                    .withInt("age", 24)
                    .withLong("time", System.currentTimeMillis()).navigation();
        }
    }
}
