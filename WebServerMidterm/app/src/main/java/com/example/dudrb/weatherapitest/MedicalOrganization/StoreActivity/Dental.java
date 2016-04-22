package com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreDental;
import com.example.dudrb.weatherapitest.R;

public class Dental extends Activity {
    StoreDental storeDental;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental);
        storeDental = new StoreDental();
        textView = (TextView)findViewById(R.id.textView_dental);
        textView.setText(storeDental.getDental().toString());
    }
}
