package com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreOriental;
import com.example.dudrb.weatherapitest.R;

public class Oriental extends Activity {

    StoreOriental storeOriental;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oriental);
        textView=(TextView)findViewById(R.id.textView_oriental);
        storeOriental = new StoreOriental();

        textView.setText(storeOriental.getOriental().toString());

    }
}
