package com.shi_zhao.play.android.play;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.layout_class.dropdownLayout.LQRDropdownLayout;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.amap.navi.demo.*;

/**
 * Created by shizhao on 2018/3/11.
 */

public class Demo1Activity extends AppCompatActivity {
    private LQRDropdownLayout mDl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        mDl = (LQRDropdownLayout) findViewById(R.id.dl);
        mDl.setCols(2);

        //创建内容区
        TextView tv = new TextView(this);
        tv.setText("我是内容，可以是View，也可以是ViewGroup");

        //创建下拉列表数据
        final List<Map<String, String>> listData = new ArrayList<>();
        for (int i = 0; i < mDl.getCols(); i++) {
            //这里使用LinkedHashMap是为了让下拉列表的条目有序
            Map<String, String> map = new LinkedHashMap<>();
            for (int j = 0; j < 20; j++) {
                map.put("name " + j, "value " + j);
            }
            listData.add(map);
        }


        mDl.init(tv, listData);
        mDl.setOnDropdownListListener(new LQRDropdownLayout.OnDropdownListListener() {
            @Override
            public void OnDropdownListSelected(int indexOfButton, int indexOfList, String textOfList, String valueOfList) {

            }

            @Override
            public void onDropdownListOpen() {

            }

            @Override
            public void onDropdownListClosed() {

            }
        });
    }

}
