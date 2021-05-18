package com.shi_zhao.play.android.play.Operation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.TheSecretOfPet.entity.Pet;
import com.TheSecretOfPet.information.AddpetRequest;
import com.amap.navi.demo.*;

import com.shi_zhao.play.android.play.Operation.Passenger_operation.ClientAddpet;
import com.shi_zhao.play.android.play.StaticInformation.ErrorTypeInformation;
import com.shi_zhao.play.android.play.StaticInformation.HandleMessageInformation;
import com.shi_zhao.play.android.play.StaticInformation.NecessaryInformation;

public class AddpetActivity extends AppCompatActivity {
    private Button Button_finish;
    private EditText Workername;
    private EditText Pettype;
    private EditText Petid;
    private EditText Petage;
    private EditText Petkg;
    private Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pet);
        initView();
        initHandler();
    }
    public void initView()
    {
        Button_finish= (Button) findViewById(R.id.button_finish);
        Workername = (EditText)findViewById(R.id.text_petname);
        Pettype = (EditText)findViewById(R.id.text_pet_type);
        Petid = (EditText)findViewById(R.id.text_pet_id);
        Petage = (EditText)findViewById(R.id.text_petage);
        Petkg = (EditText)findViewById(R.id.text_petkg);
    }

    public void initHandler(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == HandleMessageInformation.REGISTER_SUCCESS){
                    Toast.makeText(AddpetActivity.this,"跳转中",Toast.LENGTH_LONG).show();
                    try {
                        new Thread().sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent();
                    intent.setClass(AddpetActivity.this, TurnInActivity.class);
                    startActivity(intent);
                }
            }
        };
    }
    public void addpetHandler(View source){
        Pet pet = new Pet(Petid.getText().toString(),27,31,50,Integer.parseInt(Petage.getText().toString()),1,
                Pettype.getText().toString(),Integer.parseInt(Petkg.getText().toString()),Workername.getText().toString(),"小白");
        RegisterCommunication register = new RegisterCommunication(pet);
        register.start();
        try {
            new Thread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (NecessaryInformation.REGISTER_STATUS == ErrorTypeInformation.WAITING_FOR_REPORT){
            handler.sendEmptyMessage(HandleMessageInformation.WAITING_FOR_REPORT);
            Toast.makeText(AddpetActivity.this,"注册中...",Toast.LENGTH_SHORT).show();
            try {
                new Thread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        switch (NecessaryInformation.REGISTER_STATUS){
            case ErrorTypeInformation.REGISTER_SUCCESS:
                Toast.makeText(AddpetActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                handler.sendEmptyMessage(HandleMessageInformation.REGISTER_SUCCESS);
                break;
            case ErrorTypeInformation.REGISTER_EXISTED:
                handler.sendEmptyMessage(HandleMessageInformation.REGISTER_USER_EXISTED);
                Toast.makeText(AddpetActivity.this,"用户已存在",Toast.LENGTH_SHORT).show();
                break;
            case ErrorTypeInformation.REGISTER_OTHER_ERROR:
                handler.sendEmptyMessage(HandleMessageInformation.REGISTER_OTHER_ERROR);
                Toast.makeText(AddpetActivity.this,"未知错误",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    class RegisterCommunication extends Thread{
        Pet pet = null;

        public RegisterCommunication(Pet pet){
            this.pet = pet;
        }

        @Override
        public void run() {
            ClientAddpet clientAddpet = new ClientAddpet();
            AddpetRequest addpetRequest = new AddpetRequest(pet);
            clientAddpet.send(addpetRequest);
            NecessaryInformation.REGISTER_STATUS = clientAddpet.receive();
        }
    }
}
