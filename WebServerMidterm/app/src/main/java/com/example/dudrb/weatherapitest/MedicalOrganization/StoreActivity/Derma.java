package com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreDerma;
import com.example.dudrb.weatherapitest.R;

public class Derma extends Activity {
    StoreDerma storederma;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derma);
        storederma = new StoreDerma();
        textview = (TextView)findViewById(R.id.textView_derma);

        textview.setText(storederma.getDerma().toString());
    }
}
