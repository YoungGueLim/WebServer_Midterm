package com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreAllInfoEng;
import com.example.dudrb.weatherapitest.R;

public class MedicdalDetailEng extends Activity {

    TextView textView;
    StoreAllInfoEng storeAllInfoEng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicdal_detail_eng);
        textView=(TextView)findViewById(R.id.textView_detail_eng);
        storeAllInfoEng = new StoreAllInfoEng();

        textView.setText(storeAllInfoEng.getStore_allinfo().toString());
    }
}
