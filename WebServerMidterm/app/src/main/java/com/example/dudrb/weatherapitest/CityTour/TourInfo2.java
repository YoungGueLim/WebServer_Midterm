package com.example.dudrb.weatherapitest.CityTour;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.R;

public class TourInfo2 extends Activity {

    TextView textView6,textView7,textView8,textView9,textView10;
    TourList tourlist_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_info2);

        tourlist_info = new TourList();
        textView6   = (TextView)findViewById(R.id.tour_list1);
        textView7   = (TextView)findViewById(R.id.textView17);
        textView8  = (TextView)findViewById(R.id.textView18);
        textView9  = (TextView)findViewById(R.id.textView19);
        textView10  = (TextView)findViewById(R.id.textView20);

        textView6.setText( tourlist_info.getTourlist().get(0).getDRV_6().toString());
        textView7.setText(tourlist_info.getTourlist().get(0).getDRV_7().toString());
        textView8.setText(tourlist_info.getTourlist().get(0).getDRV_8().toString());
        textView9.setText(tourlist_info.getTourlist().get(0).getDRV_9().toString());
        textView10.setText(tourlist_info.getTourlist().get(0).getDRV_10().toString());

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.button11:
                finish();
                startActivity(new Intent(this,TourInfo1.class));
                break;
            case R.id.button12:
                finish();
                startActivity(new Intent(this,TourInfo3.class));
                break;
        }
    }
}
