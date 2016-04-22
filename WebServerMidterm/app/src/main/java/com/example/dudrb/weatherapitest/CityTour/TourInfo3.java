package com.example.dudrb.weatherapitest.CityTour;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.R;

public class TourInfo3 extends Activity {

    TextView textView11,textView12;
    TourList tourlist_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_info3);

        tourlist_info = new TourList();
        textView11   = (TextView)findViewById(R.id.tour_list1);
        textView12  = (TextView)findViewById(R.id.textView17);

        textView11.setText(tourlist_info.getTourlist().get(0).getDRV_11().toString());
        textView12.setText(tourlist_info.getTourlist().get(0).getDRV_12().toString());

    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.button9:
                finish();
                startActivity(new Intent(this,TourInfo2.class));
                break;
        }
    }
}
