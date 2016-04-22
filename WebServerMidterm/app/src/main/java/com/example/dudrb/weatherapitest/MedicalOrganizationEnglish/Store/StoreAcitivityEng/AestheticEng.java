package com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreAcitivityEng;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreAestheticEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreDentalEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreDermaEng;
import com.example.dudrb.weatherapitest.R;

public class AestheticEng extends Activity {

    StoreAestheticEng storeAestheticEng;
    StoreDermaEng storeDermaEng;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aesthetic_eng);
        storeAestheticEng = new StoreAestheticEng();
        storeDermaEng = new StoreDermaEng();
        textView = (TextView)findViewById(R.id.textView_aesthetic);

        textView.setText(storeAestheticEng.getAesthetic().toString() +
                storeDermaEng.getDerma().toString());
    }
}
