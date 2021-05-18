package com.statisticsview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amap.navi.demo.R;
import com.shi_zhao.play.android.play.Operation.Passenger_operation.MoreifoActivity;
import com.shi_zhao.play.android.play.Operation.Passenger_operation.ProductActivity;
import com.shi_zhao.play.android.play.StaticInformation.NecessaryInformation;
import com.statisticsview.view.StatisticsView;

public class MainActivity extends AppCompatActivity {

    private StatisticsView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);

        view = (StatisticsView) findViewById(R.id.statisticsView);
        View view;
        this.view.setBottomStr(new String[]{"7:00","11：00","15：00","19：00","23：00","3：00"});

        this.view.setValues(new float[]{Float.parseFloat(NecessaryInformation.newCompanyMessage.getTu().getSeven()),
                Float.parseFloat(NecessaryInformation.newCompanyMessage.getTu().getOneone()),
                Float.parseFloat(NecessaryInformation.newCompanyMessage.getTu().getOnefive()),
                Float.parseFloat(NecessaryInformation.newCompanyMessage.getTu().getOnenine()),
                Float.parseFloat(NecessaryInformation.newCompanyMessage.getTu().getTwothree()),
                Float.parseFloat(NecessaryInformation.newCompanyMessage.getTu().getThree())});
    }

    public void tufanhuiHandler(View source){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, MoreifoActivity.class);//DriverInformationActivitty
        startActivity(intent);
    }

}
