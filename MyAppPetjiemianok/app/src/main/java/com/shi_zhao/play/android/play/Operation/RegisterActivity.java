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

import com.TheSecretOfPet.entity.Worker;
import com.TheSecretOfPet.information.RegisterRequest;
import com.shi_zhao.play.android.play.Operation.Passenger_operation.ClientWorkerRegister;
import com.amap.navi.demo.*;

import com.shi_zhao.play.android.play.StaticInformation.ErrorTypeInformation;
import com.shi_zhao.play.android.play.StaticInformation.HandleMessageInformation;
import com.shi_zhao.play.android.play.StaticInformation.NecessaryInformation;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class RegisterActivity extends AppCompatActivity {
    private Button register_btn;
    private EditText username_edit;
    private EditText password;
    private EditText workername;
    private EditText PetID;
    private EditText phone;
    private Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initHandler();
        register_btn = (Button) findViewById(R.id.register_button);
        username_edit = (EditText)findViewById(R.id.register_username);
        password = (EditText)findViewById(R.id.register_password);
        workername = (EditText)findViewById(R.id.register_nickname);
        PetID = (EditText)findViewById(R.id.re_petID);
        phone = (EditText)findViewById(R.id.register_phone);
    }

    public void initHandler(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == HandleMessageInformation.REGISTER_SUCCESS){
                    Toast.makeText(RegisterActivity.this,"跳转中",Toast.LENGTH_LONG).show();
                    try {
                        new Thread().sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity.this, AddpetActivity.class);
                    startActivity(intent);
                }
            }
        };
    }

    public void registerHandler(View source){
        Worker worker = new Worker(username_edit.getText().toString(),password.getText().toString(),
                    workername.getText().toString(),0,0,0,PetID.getText().toString(),phone.getText().toString());
        RegisterCommunication register = new RegisterCommunication(worker);
        register.start();
        try {
            new Thread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (NecessaryInformation.REGISTER_STATUS == ErrorTypeInformation.WAITING_FOR_REPORT){
            handler.sendEmptyMessage(HandleMessageInformation.WAITING_FOR_REPORT);
            Toast.makeText(RegisterActivity.this,"注册中...",Toast.LENGTH_SHORT).show();
            try {
                new Thread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        switch (NecessaryInformation.REGISTER_STATUS){
            case ErrorTypeInformation.REGISTER_SUCCESS:
                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                handler.sendEmptyMessage(HandleMessageInformation.REGISTER_SUCCESS);
                break;
            case ErrorTypeInformation.REGISTER_EXISTED:
                handler.sendEmptyMessage(HandleMessageInformation.REGISTER_USER_EXISTED);
                Toast.makeText(RegisterActivity.this,"用户已存在",Toast.LENGTH_SHORT).show();
                break;
            case ErrorTypeInformation.REGISTER_OTHER_ERROR:
                handler.sendEmptyMessage(HandleMessageInformation.REGISTER_OTHER_ERROR);
                Toast.makeText(RegisterActivity.this,"未知错误",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    class RegisterCommunication extends Thread{
        Worker worker = null;

        public RegisterCommunication(Worker worker){
            this.worker = worker;
        }

        @Override
        public void run() {
            ClientWorkerRegister clientworker = new ClientWorkerRegister();
            RegisterRequest registerRequest = new RegisterRequest(worker);
            clientworker.send(registerRequest);
            NecessaryInformation.REGISTER_STATUS = clientworker.receive();
        }
    }
}
