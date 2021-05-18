package com.shi_zhao.play.android.play;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.amap.navi.demo.*;


public class MainActivity extends AppCompatActivity {

    private ImageView turn_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        turn_in = (ImageView)findViewById(R.id.turn_in);
        turn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent turnIn = new Intent();
                turnIn.setClass(MainActivity.this,BeginActivity.class);// TurnInActivity.class
                startActivity(turnIn);
                finish();
            }
        });
    }
}
