package com.memoire;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * create_by Android Studio
 *
 * @author zouguo0212@
 * @package_name fun.zzti.memoire
 * @description
 * @date 2018/10/26 17:30
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        设置强制竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
