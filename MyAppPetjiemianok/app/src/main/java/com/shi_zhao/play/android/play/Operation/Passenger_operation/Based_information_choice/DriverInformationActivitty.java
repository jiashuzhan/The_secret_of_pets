package com.shi_zhao.play.android.play.Operation.Passenger_operation.Based_information_choice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.amap.navi.demo.*;

import com.shi_zhao.play.android.play.StaticInformation.NecessaryInformation;

/**
 * Created by Administrator on 2017/7/2 0002.
 */
public class DriverInformationActivitty extends AppCompatActivity {

    private TextView driver_name;
    private TextView driver_user_name;
    private TextView driver_gender;
    private TextView health_table;
    private TextView driving_year;
    private TextView phone_number;
    private TextView car_license;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_information);
        initView();
        setText();
    }


    public void setText(){
        driver_name.setText(NecessaryInformation.worker.getWorkerName());
        driver_user_name.setText(NecessaryInformation.worker.getUserName());

        if(NecessaryInformation.worker.getHealthExam() == NecessaryInformation.EXAM_HEALTHY){
            health_table.setText(this.getString(R.string.is_health));
        }else{
            health_table.setText(this.getString(R.string.is_not_health));
        }
        if(NecessaryInformation.worker.getworkersex() == NecessaryInformation.MALE){
            driver_gender.setText(this.getString(R.string.male));
        }else{
            driver_gender.setText(this.getString(R.string.female));
        }


        driving_year.setText(Integer.toString(NecessaryInformation.worker.getWorkerYears())+getString(R.string.year));

        //phone_number.setText(NecessaryInformation.worker.getTelephone());
        car_license.setText(NecessaryInformation.worker.getPetID());
    }

    public void initView(){
        driver_name = (TextView)findViewById(R.id.driver_name);
        driver_user_name = (TextView)findViewById(R.id.drid);
        driver_gender = (TextView)findViewById(R.id.xb);
        health_table = (TextView)findViewById(R.id.yx);
        driving_year = (TextView)findViewById(R.id.sj);
        //phone_number = (TextView)findViewById(R.id.phone_number);
        car_license = (TextView)findViewById(R.id.dh);
    }

}
