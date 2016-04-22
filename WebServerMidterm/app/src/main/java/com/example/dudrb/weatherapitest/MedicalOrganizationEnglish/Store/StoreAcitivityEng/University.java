package com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreAcitivityEng;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreHosUnivEng;
import com.example.dudrb.weatherapitest.R;

public class University extends Activity {

    TextView textView;
    StoreHosUnivEng storeHosUnivEng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);

        storeHosUnivEng = new StoreHosUnivEng();
        textView = (TextView)findViewById(R.id.textView_university);

        textView.setText(storeHosUnivEng.getHouUnivEng().toString());
    }
}
