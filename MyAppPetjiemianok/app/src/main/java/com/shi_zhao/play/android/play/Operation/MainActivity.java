package com.shi_zhao.play.android.play.Operation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.amap.navi.demo.*;
import com.shi_zhao.play.android.play.Demo1Activity;
import com.shi_zhao.play.android.play.Demo2Activity;

public class MainActivity extends AppCompatActivity {


    private Button demo1;
    private Button demo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        init();
    }

    public void init(){
        demo1 = (Button)findViewById(R.id.demo1);
        demo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Demo1Activity.class));
            }
        });
        demo2 = (Button)findViewById(R.id.demo2);
        demo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Demo2Activity.class));
            }
        });
    }


    public void demo1(View view) {
        startActivity(new Intent(MainActivity.this, Demo1Activity.class));
    }

    public void demo2(View view) {
        startActivity(new Intent(MainActivity.this, Demo2Activity.class));
    }
}
