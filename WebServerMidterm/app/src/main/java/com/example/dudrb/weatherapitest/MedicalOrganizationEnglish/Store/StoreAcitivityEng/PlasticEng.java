package com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreAcitivityEng;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StorePlasticEng;
import com.example.dudrb.weatherapitest.R;

public class PlasticEng extends Activity {

    TextView textview;
    StorePlasticEng storePlasticEng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastic_eng);

        textview = (TextView)findViewById(R.id.textView_plastic_eng);
        storePlasticEng = new StorePlasticEng();

        textview.setText(storePlasticEng.getPlastic().toString());
    }
}
