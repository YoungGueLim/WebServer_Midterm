package com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreHospUniv;
import com.example.dudrb.weatherapitest.R;

public class HospUniv extends AppCompatActivity {
    TextView textView ;
    StoreHospUniv storeHospUniv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosp_univ);
        textView=(TextView)findViewById(R.id.textview_hostuniv);
        storeHospUniv = new StoreHospUniv();

        textView.setText(storeHospUniv.getStore().toString());
    }
}
