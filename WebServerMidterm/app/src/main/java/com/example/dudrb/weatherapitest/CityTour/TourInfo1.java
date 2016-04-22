package com.example.dudrb.weatherapitest.CityTour;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.R;

public class TourInfo1 extends Activity {

    TextView textView,textView2,textView3,textView4,textView5;
    TourList tourlist_info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_info1);

        tourlist_info = new TourList();

        textView   = (TextView)findViewById(R.id.tour_list1);
        textView2   = (TextView)findViewById(R.id.textView17);
        textView3  = (TextView)findViewById(R.id.textView18);
        textView4  = (TextView)findViewById(R.id.textView19);
        textView5  = (TextView)findViewById(R.id.textView20);

        textView.setText(tourlist_info.getTourlist().get(0).getDRV_1().toString());
        textView2.setText(tourlist_info.getTourlist().get(0).getDRV_2().toString());
        textView3.setText(tourlist_info.getTourlist().get(0).getDRV_3().toString());
        textView4.setText(tourlist_info.getTourlist().get(0).getDRV_4().toString());
        textView5.setText(tourlist_info.getTourlist().get(0).getDRV_5().toString());

    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    public  void onClick(View v)
    {
        finish();
        startActivity(new Intent(this,TourInfo2.class));
    }

}
