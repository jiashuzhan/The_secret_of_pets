package com.shi_zhao.play.android.play.Operation.Passenger_operation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.TheSecretOfPet.entity.PetInformation;
import com.TheSecretOfPet.information.PetInnerinformationRefreshRequest;
import com.amap.navi.demo.activity.DriverIndexActivity;
import com.amap.navi.demo.*;

import com.fenshu.CompletedView;
import com.shi_zhao.play.android.play.Operation.Passenger_operation.Based_information_choice.DriverInformationActivitty;
import com.shi_zhao.play.android.play.StaticInformation.NecessaryInformation;

/**
 * Created by Administrator on 2017/7/2 0002.
 */
public class DriverChooseActivity extends AppCompatActivity {

    private ImageButton driverInfoButton;
    private ImageButton transparent;
    private ImageButton company_report;
    private TextView Age;
    private TextView Petname;
    private TextView Petstep;
    private TextView Heartrate;
    private TextView RoomTemperature;
    private TextView PetTemperature;
    private TextView longitude;
    private TextView latitude;
    private TextView lightValue;
    private ToggleButton sw1;
    private ToggleButton sw2;
    private ToggleButton sw3;
    private ToggleButton sw4;

    private int mTotalProgress = 90;
    private int mCurrentProgress = 0;
    //进度条
    private CompletedView mTasksView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_choose);
        mTasksView = (CompletedView) findViewById(R.id.tasks_view);

        new Thread(new ProgressRunable()).start();
        initView();
    }
    class ProgressRunable implements Runnable {
        @Override
        public void run() {
            while (mCurrentProgress < mTotalProgress) {
                mCurrentProgress += 1;
                mTasksView.setProgress(mCurrentProgress);
                try {
                    Thread.sleep(90);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void initView(){
        driverInfoButton = (ImageButton)findViewById(R.id.driver_information);
        Age =(TextView)findViewById(R.id.age);
        //Petname = (TextView)findViewById(R.id.petname);
        Petstep = (TextView)findViewById(R.id.petstep);
        Heartrate = (TextView)findViewById(R.id.heartrate);
        RoomTemperature = (TextView)findViewById(R.id.car_temperature);
        PetTemperature = (TextView)findViewById(R.id.pettemperature);
        longitude = (TextView)findViewById(R.id.longtitude);
        latitude = (TextView)findViewById(R.id.latitude);
        lightValue = (TextView)findViewById(R.id.light_value);
        sw1 = (ToggleButton)findViewById(R.id.sw1);
        sw2 = (ToggleButton)findViewById(R.id.sw2);
        sw3 = (ToggleButton)findViewById(R.id.sw3);
        sw4 = (ToggleButton)findViewById(R.id.sw4);
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    NecessaryInformation.newCompanyMessage.getPetInformations().get(0).setLightStatusOne(1);
                }else {
                    NecessaryInformation.newCompanyMessage.getPetInformations().get(0).setLightStatusOne(0);
                }
                //Toast.makeText(DriverChooseActivity.this,NecessaryInformation.newCompanyMessage.getBusInnerInformations().get(0).toString(),Toast.LENGTH_SHORT).show();
                new BusInformationSend().start();
            }
        });
        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    NecessaryInformation.newCompanyMessage.getPetInformations().get(0).setLightStatusTwo(1);
                }else {
                    NecessaryInformation.newCompanyMessage.getPetInformations().get(0).setLightStatusTwo(0);
                }
                //Toast.makeText(DriverChooseActivity.this,NecessaryInformation.newCompanyMessage.getBusInnerInformations().get(0).toString(),Toast.LENGTH_SHORT).show();

                new BusInformationSend().start();
            }
        });
        sw3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    NecessaryInformation.newCompanyMessage.getPetInformations().get(0).setLightStatusThree(1);
                }else {
                    NecessaryInformation.newCompanyMessage.getPetInformations().get(0).setLightStatusThree(0);
                }
                //Toast.makeText(DriverChooseActivity.this,NecessaryInformation.newCompanyMessage.getBusInnerInformations().get(0).toString(),Toast.LENGTH_SHORT).show();

                new BusInformationSend().start();
            }
        });
        sw4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    NecessaryInformation.newCompanyMessage.getPetInformations().get(0).setLightStatusFour(1);
                }else {
                    NecessaryInformation.newCompanyMessage.getPetInformations().get(0).setLightStatusFour(0);
                }
                //Toast.makeText(DriverChooseActivity.this,NecessaryInformation.newCompanyMessage.getBusInnerInformations().get(0).toString(),Toast.LENGTH_SHORT).show();

                new BusInformationSend().start();
            }
        });
        textShow();
    }

    public void textShow(){
        Age.setText("8");
        //Petname.setText(NecessaryInformation.newCompanyMessage.getPetInformations().get(0).getPetID());
        Petstep.setText("2175");//3/20
        Heartrate.setText("62次/分钟");//3/20
        RoomTemperature.setText(NecessaryInformation.newCompanyMessage.getPetInformations().get(0).getroomTemperature() + "");
        PetTemperature.setText(NecessaryInformation.newCompanyMessage.getPetInformations().get(0).getPetTemperature()+"");
        longitude.setText(NecessaryInformation.newCompanyMessage.getPetInformations().get(0).getPetLongitude() + "");
        latitude.setText(NecessaryInformation.newCompanyMessage.getPetInformations().get(0).getPetLatitude()+"");
        //longitude.setText("121.16339633");
        //latitude.setText("28.88107083");
        lightValue.setText("37");
        if (NecessaryInformation.newCompanyMessage.getPetInformations().get(0).getLightStatusOne() == 1){
            sw1.setChecked(true);
        }else {
            sw1.setChecked(false);
        }
        if (NecessaryInformation.newCompanyMessage.getPetInformations().get(0).getLightStatusTwo() == 1){
            sw2.setChecked(true);
        }else {
            sw2.setChecked(false);
        }
        if (NecessaryInformation.newCompanyMessage.getPetInformations().get(0).getLightStatusThree() == 1){
            sw3.setChecked(true);
        }else{
            sw3.setChecked(false);
        }
        if (NecessaryInformation.newCompanyMessage.getPetInformations().get(0).getLightStatusFour() == 1){
            sw4.setChecked(true);
        }else {
            sw4.setChecked(false);
        }
    }
    public void WorkerInformationHandler(View source){
        Intent intent = new Intent();
        intent.setClass(DriverChooseActivity.this, DriverInformationActivitty.class);
        startActivity(intent);
    }
    public void returnhomeHandler(View source){
        Intent intent = new Intent();
        intent.setClass(DriverChooseActivity.this, DriverChooseActivity.class);
        startActivity(intent);
    }
    public void transientHandler(View source){
        Intent intent = new Intent();
        intent.setClass(DriverChooseActivity.this, MoreifoActivity.class);//////////////////////////
        startActivity(intent);
    }

    public void driverInfoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(DriverChooseActivity.this, PassengerChooseActivity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }

    public void driverNaviHandler(View source){
        Intent intent = new Intent();
        intent.setClass(DriverChooseActivity.this, DriverIndexActivity.class);

        startActivity(intent);
        finish();
    }

    public void driverChangeBusInformationSend(View source){
        BusInformationReceive busInformationReceive = new BusInformationReceive();
        busInformationReceive.start();
        textShow();
    }
    class BusInformationSend extends Thread{

        PetInformation petInnerInformation;
        @Override
        public void run() {
            petInnerInformation = NecessaryInformation.newCompanyMessage.getPetInformations().get(0);
            ClientWorker clientDriver = new ClientWorker();
            clientDriver.send(petInnerInformation);
        }
    }
    class BusInformationReceive extends Thread{
        PetInformation busInnerInformation;
        @Override
        public void run() {
            ClientWorker clientDriver = new ClientWorker();
            clientDriver.send(new PetInnerinformationRefreshRequest(NecessaryInformation.worker));
            clientDriver.receiveBusInnerInformation();
        }
    }
    /*public void manager_send_infoButtonHandler(View source){
        Intent intent = new Intent();
        intent.setClass(DriverChooseActivity.this, ManagerMassageSendActivity.class);
        startActivity(intent);
    }*/
}
