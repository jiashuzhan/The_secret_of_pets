package com.shi_zhao.play.android.play.Operation.Passenger_operation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.amap.navi.demo.*;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class PassengerChooseActivity  extends AppCompatActivity{

    private ImageButton userInfo;
    private ImageButton busInfo;
    private ImageButton userSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading);
        initView();

    }

    public void initView(){

        /*userInfo = (ImageButton)findViewById(R.id.user_information);
        busInfo = (ImageButton)findViewById(R.id.bus_information);
        userSetting = (ImageButton)findViewById(R.id.user_setting);
        */

    }

    public void userInfoHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, PassengerChooseActivity.class);
        startActivity(intent);
    }

    /*public void busInfoHandler(View source){
       // Intent intent = new Intent();
        setContentView(R.layout.businfo_group);
    }*/

    public void returnhomeHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, DriverChooseActivity.class);
        startActivity(intent);
    }
    public void transientHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, MoreifoActivity.class);//////////////////////////
        startActivity(intent);
    }

    public void driverInfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, PassengerChooseActivity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }
    public void news1InfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, News1Activity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }public void news2InfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, News2Activity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }public void news3InfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, News3Activity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }public void news4InfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, News4Activity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }public void news5InfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, News5Activity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }public void news6InfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, News6Activity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }public void news7InfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, News7Activity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }
    public void turn1InfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(PassengerChooseActivity.this, Turn1Activity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }
}
