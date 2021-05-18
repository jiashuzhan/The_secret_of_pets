package com.shi_zhao.play.android.play;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.navi.demo.*;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class TestActivity extends AppCompatActivity {
    private MapView mapView;
    private AMap aMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testandroid);
        TextView textView = (TextView)findViewById(R.id.test);
        textView.setText("111111111111111111");
        mapView = (MapView)findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        init();
        ToggleButton toggleButton = (ToggleButton)findViewById(R.id.tb);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
                else
                    aMap.setMapType(AMap.MAP_TYPE_NORMAL);
            }
        });
    }
    private void init(){
        if(aMap == null){
            aMap = mapView.getMap();
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
