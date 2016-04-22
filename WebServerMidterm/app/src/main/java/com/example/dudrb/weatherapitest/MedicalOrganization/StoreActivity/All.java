package com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreAllTitle;
import com.example.dudrb.weatherapitest.R;

public class All extends Activity {
    StoreAllTitle storeAllTitle;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        storeAllTitle = new StoreAllTitle();
        textView=(TextView)findViewById(R.id.textView_all);

        textView.setText(storeAllTitle.getAll().toString());
    }
}
