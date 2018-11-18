package com.nerolink.arouterlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Date;

@Route(path = "/test/empty")
public class EmptyActivity extends AppCompatActivity {

    @Autowired
    public String name;
    @Autowired
    public int age;
    @Autowired
    public Long time;

    private static final String TAG = "EmptyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        ARouter.getInstance().inject(this);
        Log.e(TAG, "onCreate: "+name);
        Log.e(TAG, "onCreate: "+age);
        Log.e(TAG, "onCreate: "+time);
    }
}
