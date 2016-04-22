package com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreAcitivityEng;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreAllInfoEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreDentalEng;
import com.example.dudrb.weatherapitest.R;

public class DentalEng extends Activity {
    StoreDentalEng storeDentalEng;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental_eng);
        textView = (TextView)findViewById(R.id.textView_detail_eng);
        storeDentalEng = new StoreDentalEng();

        textView.setText(storeDentalEng.getDental().toString());
    }
}
