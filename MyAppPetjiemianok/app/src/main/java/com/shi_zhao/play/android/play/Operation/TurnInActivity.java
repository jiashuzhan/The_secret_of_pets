package com.shi_zhao.play.android.play.Operation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.TheSecretOfPet.information.LoginUser;
import com.shi_zhao.play.android.play.Operation.Passenger_operation.ClientWorker;
import com.shi_zhao.play.android.play.Operation.Passenger_operation.DriverChooseActivity;
import com.shi_zhao.play.android.play.Operation.Passenger_operation.PassengerChooseActivity;
import com.amap.navi.demo.*;

import com.shi_zhao.play.android.play.StaticInformation.ErrorTypeInformation;
import com.shi_zhao.play.android.play.StaticInformation.HandleMessageInformation;
import com.shi_zhao.play.android.play.StaticInformation.NecessaryInformation;
import com.sina.weibo.sdk.demo.WBDemoMainActivity;


import java.util.Date;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
/*
用于登录，知道选择哪一个类型后到了这个界面，然后出现对应的登录界面，然后输入密码账户，登录相应的用户界面
 */
public class TurnInActivity extends AppCompatActivity{
    ImageButton typeUser;
    Button forget;
    Button resign;
    Button login_button;
    int typeImage;
    private TextView userName;
    private TextView password;
    private Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.turn_in);
        initHandler();//获取msg 然后进入相应界面；
        getViewFromContent();
        getTypeOfUser();
        typeUser.setImageResource(typeImage);
        login_button = (Button)findViewById(R.id.login_button);
    }

    public void initHandler(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Intent intent = new Intent();
                if(msg.what == HandleMessageInformation.SUCCESS_LOGIN){
                    intent.setClass(TurnInActivity.this,PassengerChooseActivity.class);
                    startActivity(intent);
                }
                if(msg.what == HandleMessageInformation.DRIVER_LOGIN_SUCCESS){
                    intent.setClass(TurnInActivity.this, DriverChooseActivity.class);
                    startActivity(intent);
                }

            }
        };
    }

    public void loginButtonHandler(View source){
        //Toast.makeText(this,userName.getText().toString(),Toast.LENGTH_SHORT).show();
        //Toast.makeText(this,password.getText().toString(),Toast.LENGTH_SHORT).show();
        LoginUser loginUser = new LoginUser(userName.getText().toString(),password.getText().toString(),NecessaryInformation.LOGIN_IN_TIME,new Date());

        if(NecessaryInformation.LOGIN_IN_TIME == NecessaryInformation.USER_LOGIN_TYPE_DRIVER){
            SocketWorker socketWorker = new SocketWorker(loginUser);
            socketWorker.start();
            Toast.makeText(TurnInActivity.this,"请等待",Toast.LENGTH_SHORT).show();
            try {
                new Thread().sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (NecessaryInformation.LOGIN_STATUS == ErrorTypeInformation.WAITING_FOR_REPORT){
                handler.sendEmptyMessage(HandleMessageInformation.WAITING_FOR_REPORT);
                Toast.makeText(TurnInActivity.this,"请等待",Toast.LENGTH_SHORT).show();
            }

            switch (NecessaryInformation.LOGIN_STATUS){
                case ErrorTypeInformation.SUCCESS_NONE_ERROR:
                    Toast.makeText(TurnInActivity.this,"验证成功",Toast.LENGTH_SHORT).show();
                    handler.sendEmptyMessage(HandleMessageInformation.DRIVER_LOGIN_SUCCESS);
                    /*Intent intent = new Intent();
                    intent.setClass(TurnInActivity.this, DriverChooseActivity.class);/////////
                    startActivity(intent);*/
                    break;
                case ErrorTypeInformation.PASSWORD_ERROR:
                    handler.sendEmptyMessage(HandleMessageInformation.PASSWORD_ERROR_LOGIN);
                    Toast.makeText(TurnInActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                    break;
                case ErrorTypeInformation.KEY_NUM_ERROR:
                    handler.sendEmptyMessage(HandleMessageInformation.KEY_NUM_ERROR_LOGIN);
                    Toast.makeText(TurnInActivity.this,"验证码错误",Toast.LENGTH_SHORT).show();
                    break;
                case ErrorTypeInformation.NONE_USERNAME_ERROR:
                    handler.sendEmptyMessage(HandleMessageInformation.NONE_USER_ERROR_LOGIN);
                    Toast.makeText(TurnInActivity.this,"无此用户",Toast.LENGTH_SHORT).show();
                    break;
                case ErrorTypeInformation.OTHER_ERROR:
                    handler.sendEmptyMessage(HandleMessageInformation.OTHER_ERROR_LOGIN);
                    Toast.makeText(TurnInActivity.this,"未知错误",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }


    class SocketWorker extends Thread{
        LoginUser loginUser = null;
        public SocketWorker(LoginUser loginUser ){
            this.loginUser = loginUser;
        }
        @Override
        public void run() {
            ClientWorker clientworker = new ClientWorker();
            clientworker.send(loginUser);
            NecessaryInformation.LOGIN_STATUS = clientworker.receive();
        }
    }

    public void getTypeOfUser(){
        switch (NecessaryInformation.LOGIN_IN_TIME){
            case NecessaryInformation.USER_LOGIN_TYPE_PASSENGER:
                forget.setVisibility(View.VISIBLE);
                resign.setVisibility(View.VISIBLE);
                typeImage = R.drawable.login_user_icon;
                break;
            case NecessaryInformation.USER_LOGIN_TYPE_DRIVER:
                forget.setVisibility(View.VISIBLE);
                resign.setVisibility(View.VISIBLE);
                typeImage = R.drawable.login_driver_icon;
                break;
            case NecessaryInformation.USER_LOGIN_TYPE_MANAGER:
                forget.setVisibility(View.VISIBLE);
                resign.setVisibility(View.VISIBLE);
                typeImage = R.drawable.login_manager_icon;
                break;
        }
    }
    public void turnInBackHandler(View source){
        finish();
    }
    public void getViewFromContent(){
        typeUser = (ImageButton)findViewById(R.id.type_user_btn);
        forget = (Button)findViewById(R.id.button2);
        resign = (Button)findViewById(R.id.register_choose);
        userName = (TextView)findViewById(R.id.user_name);
        password = (TextView)findViewById(R.id.user_password);
    };
    //用户注册
    public void registerChooseHandler(View source){
        Intent intent = new Intent();
        intent.setClass(TurnInActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
    public void sinaLoginChooseHandeler(View source){
        Intent intent = new Intent();
        intent.setClass(TurnInActivity.this,WBDemoMainActivity.class);
        startActivity(intent);
    }
}
