package com.shi_zhao.play.android.play.Operation.Passenger_operation;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amap.navi.demo.*;

public class ContactActivity extends AppCompatActivity {
    String numbereditText;
    String messageeditText;
    Button button;
    EditText  Cemil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        numbereditText= "17858263951";
        Cemil= (EditText) findViewById(R.id.contact_email);
        button= (Button) findViewById(R.id.send);
        SmsManager sm = SmsManager.getDefault();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(numbereditText,null,
                        Cemil.getText().toString(),null,null);
            }
        });
    }
    public void returnHandler(View source){
        Intent intent = new Intent();
        intent.setClass( ContactActivity.this,MoreifoActivity.class);//DriverInformationActivitty.class
        startActivity(intent);
    }
}

