package com.shi_zhao.play.android.play.Operation.Passenger_operation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.amap.navi.demo.*;
import com.memoire.MainActivity;
import com.shi_zhao.play.android.play.Operation.Passenger_operation.Based_information_choice.DriverInformationActivitty;

public class MoreifoActivity extends AppCompatActivity{

    private ImageButton User_button;
    private TextView Notebook;
    private TextView Recorkd;
    private TextView Manual;
    private TextView Us;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moreifo);
        initView();
    }
    public void initView()
    {
        User_button = (ImageButton)findViewById(R.id.user_button);
        //Notebook =(TextView)findViewById(R.id.notebook);
        //Recorkd = (TextView)findViewById(R.id.record);
       //Manual = (TextView)findViewById(R.id.manual);
        //Us = (TextView)findViewById(R.id.us);
    }
    public void transientHandler(View source){
        Intent intent = new Intent();
        intent.setClass( MoreifoActivity.this, MoreifoActivity.class);
        startActivity(intent);
    }

    public void driverInfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass( MoreifoActivity.this, PassengerChooseActivity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }
    public void returnhomeHandler(View source){
        Intent intent = new Intent();
        intent.setClass( MoreifoActivity.this,DriverChooseActivity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }
    public void contactusHandler(View source){
        Intent intent = new Intent();
        intent.setClass( MoreifoActivity.this,ContactActivity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }
    public void petbookHandler(View source){
        Intent intent = new Intent();
        intent.setClass( MoreifoActivity.this, MainActivity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }
    public void WorkerInformationHandler(View source){
        Intent intent = new Intent();
        intent.setClass(MoreifoActivity.this, DriverInformationActivitty.class);//DriverInformationActivitty
        startActivity(intent);
    }
    public void productHandler(View source){
        Intent intent = new Intent();
        intent.setClass(MoreifoActivity.this, ProductActivity.class);//DriverInformationActivitty
        startActivity(intent);
    }
    public void tuHandler(View source){
        Intent intent = new Intent();
        intent.setClass(MoreifoActivity.this, com.statisticsview.MainActivity.class);//DriverInformationActivitty
        startActivity(intent);
    }
}

