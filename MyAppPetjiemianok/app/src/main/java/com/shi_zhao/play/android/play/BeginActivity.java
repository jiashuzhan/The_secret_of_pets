package com.shi_zhao.play.android.play;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import com.amap.navi.demo.*;
import com.shi_zhao.play.android.play.Operation.TurnInActivity;
import com.shi_zhao.play.android.play.StaticInformation.NecessaryInformation;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class







BeginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.begin_activity);
        NecessaryInformation.LOGIN_IN_TIME = NecessaryInformation.USER_LOGIN_TYPE_DRIVER;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(BeginActivity.this, TurnInActivity.class);// ChooseActivity.class;LoginActivity.class
                startActivity(intent);
                finish();
            }
        },1500);
    }
}
