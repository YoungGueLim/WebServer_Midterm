package com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreAllInfo;
import com.example.dudrb.weatherapitest.R;

public class MedicalDetail extends Activity {
    TextView textView ;
    StoreAllInfo storeAllInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_detail);
        textView = (TextView)findViewById(R.id.textView_Detail);
        storeAllInfo = new StoreAllInfo();

        textView.setText(storeAllInfo.getStore_allinfo().toString());
    }
}
