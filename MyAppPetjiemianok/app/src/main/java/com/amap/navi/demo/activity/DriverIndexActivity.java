package com.amap.navi.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviTheme;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.AmapPageType;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.navi.demo.R;
import com.amap.navi.demo.activity.custom.ComponentActivity;
import com.amap.navi.demo.activity.view.FeatureView;
import com.amap.navi.demo.util.CheckPermissionsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shizhao on 2018/3/11.
 */

public class DriverIndexActivity extends CheckPermissionsActivity implements INaviInfoCallback {
    private static class DemoDetails {
        private final int titleId;
        private final int descriptionId;
        private final Class<? extends android.app.Activity> activityClass;

        public DemoDetails(int titleId, int descriptionId,
                           Class<? extends android.app.Activity> activityClass) {
            super();
            this.titleId = titleId;
            this.descriptionId = descriptionId;
            this.activityClass = activityClass;
        }
    }

    private static class CustomArrayAdapter extends ArrayAdapter<DriverIndexActivity.DemoDetails> {
        public CustomArrayAdapter(Context context, DriverIndexActivity.DemoDetails[] demos) {
            super(context, R.layout.feature, R.id.title, demos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            FeatureView featureView;
            if (convertView instanceof FeatureView) {
                featureView = (FeatureView) convertView;
            } else {
                featureView = new FeatureView(getContext());
            }
            DriverIndexActivity.DemoDetails demo = getItem(position);
            featureView.setTitleId(demo.titleId, demo.activityClass!=null);
            return featureView;
        }
    }

    private static final DriverIndexActivity.DemoDetails[] demos = {
//		    // 导航组件
            new DriverIndexActivity.DemoDetails(R.string.navi_ui, R.string.blank, null),
            // 组件起终点算路
            new DriverIndexActivity.DemoDetails(R.string.navi_start_end_poi_calculate_title, R.string.navi_start_end_poi_calculate_desc, ComponentActivity.class),
            // 组件起终点算路
            new DriverIndexActivity.DemoDetails(R.string.navi_end_poi_calculate_title, R.string.navi_end_poi_calculate_desc, ComponentActivity.class),
            // 组件起终点算路
            new DriverIndexActivity.DemoDetails(R.string.navi_bywayof_poi_calculate_title, R.string.navi_bywayof_poi_calculate_desc, ComponentActivity.class),
            // 直接导航
            new DriverIndexActivity.DemoDetails(R.string.navi_ui_navi_title, R.string.navi_ui_navi_desc, ComponentActivity.class),
            // 组件起终点算路（白色主题）
            new DriverIndexActivity.DemoDetails(R.string.navi_ui_component_theme_title, R.string.navi_ui_component_theme_desc, ComponentActivity.class),


    };

    LatLng p1 = new LatLng(39.993266, 116.473193);//首开广场
    LatLng p2 = new LatLng(39.917337, 116.397056);//故宫博物院
    LatLng p3 = new LatLng(39.904556, 116.427231);//北京站
    LatLng p4 = new LatLng(39.773801, 116.368984);//新三余公园(南5环)
    LatLng p5 = new LatLng(40.041986, 116.414496);//立水桥(北5环)

    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            if (position == 1) {
                AmapNaviParams params = new AmapNaviParams(new Poi("北京站", p3, ""), null, new Poi("故宫博物院", p2, ""), AmapNaviType.DRIVER);
                params.setUseInnerVoice(true);
                AmapNaviPage.getInstance().showRouteActivity(getApplicationContext(), params, DriverIndexActivity.this);
            } else if (position == 2) {
                AmapNaviPage.getInstance().showRouteActivity(getApplicationContext(), new AmapNaviParams(null, null, new Poi("故宫博物院", p2, ""), AmapNaviType.DRIVER), DriverIndexActivity.this);
            } else if (position == 3) {
                List<Poi> poiList = new ArrayList();
                poiList.add(new Poi("首开广场", p1, ""));
                poiList.add(new Poi("故宫博物院", p2, ""));
                poiList.add(new Poi("北京站", p3, ""));

                AmapNaviParams params = new AmapNaviParams(new Poi("立水桥(北5环)", p5, ""), poiList, new Poi("新三余公园(南5环)", p4, ""), AmapNaviType.DRIVER);
                params.setUseInnerVoice(true);
                AmapNaviPage.getInstance().showRouteActivity(getApplicationContext(), params, DriverIndexActivity.this);
            } else if (position == 4) {
                Poi start = new Poi("立水桥(北5环)", p5, "");//起点

                //<editor-fold desc="途径点">
                List<Poi> poiList = new ArrayList();
                poiList.add(new Poi("首开广场", p1, ""));
                poiList.add(new Poi("故宫博物院", p2, ""));
                poiList.add(new Poi("北京站", p3, ""));
                //</editor-fold>

                Poi end = new Poi("新三余公园(南5环)", p4, "");//终点
                AmapNaviParams amapNaviParams = new AmapNaviParams(start, null, end, AmapNaviType.DRIVER, AmapPageType.NAVI);
                amapNaviParams.setUseInnerVoice(true);
                AmapNaviPage.getInstance().showRouteActivity(getApplicationContext(), amapNaviParams, DriverIndexActivity.this);
            } else if (position == 5) {
                AmapNaviParams params = new AmapNaviParams(new Poi("北京站", p3, ""), null, new Poi("故宫博物院", p2, ""), AmapNaviType.DRIVER).setTheme(AmapNaviTheme.WHITE);
                params.setUseInnerVoice(true);
                AmapNaviPage.getInstance().showRouteActivity(getApplicationContext(), params, DriverIndexActivity.this);
            } else if (position == 12) {
                Intent intent = new Intent(DriverIndexActivity.this, EmulatorActivity.class);
                intent.putExtra("useInnerVoice", true);
                startActivity(intent);
            } else {
                DriverIndexActivity.DemoDetails demo = (DriverIndexActivity.DemoDetails) adapter.getItem(position);
                if (demo.activityClass != null) {
                    startActivity(new Intent(DriverIndexActivity.this, demo.activityClass));
                }
            }

        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        initView();
    }

    ListAdapter adapter;
    private void initView() {
        ListView listView = (ListView) findViewById(R.id.list);
        setTitle("智能公交为您导航");

        adapter = new DriverIndexActivity.CustomArrayAdapter(
                this.getApplicationContext(), demos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(mItemClickListener);
    }

    /**
     * 返回键处理事件
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            System.exit(0);// 退出程序
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onInitNaviFailure() {

    }

    @Override
    public void onGetNavigationText(String s) {

    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

    }

    @Override
    public void onArriveDestination(boolean b) {

    }

    @Override
    public void onStartNavi(int i) {

    }

    @Override
    public void onCalculateRouteSuccess(int[] ints) {

    }

    @Override
    public void onCalculateRouteFailure(int i) {

    }

    @Override
    public void onStopSpeaking() {

    }

    @Override
    public void onReCalculateRoute(int i) {

    }

    @Override
    public void onExitPage(int i) {

    }
}
