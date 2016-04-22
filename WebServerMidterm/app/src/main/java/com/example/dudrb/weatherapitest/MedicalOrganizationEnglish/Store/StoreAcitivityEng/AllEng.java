package com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreAcitivityEng;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreAllTitleEng;
import com.example.dudrb.weatherapitest.R;

public class AllEng extends Activity {
    StoreAllTitleEng storeAllTitleEng;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_eng);
        textView=(TextView)findViewById(R.id.textView_all_eng);
        storeAllTitleEng = new StoreAllTitleEng();

        textView.setText(storeAllTitleEng.getAllTitleEng().toString());
    }
}
