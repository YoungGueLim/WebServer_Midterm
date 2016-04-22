package com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreAcitivityEng;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreOrientalEng;
import com.example.dudrb.weatherapitest.R;

public class OrientalEng extends Activity {

    TextView textView;
    StoreOrientalEng storeOrientalEng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oriental_eng);
        storeOrientalEng = new StoreOrientalEng();
        textView = (TextView)findViewById(R.id.textView_oriental_eng);

        textView.setText(storeOrientalEng.getOriental().toString());
    }
}
