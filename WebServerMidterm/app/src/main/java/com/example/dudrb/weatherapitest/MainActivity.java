/* Medi-Tour
 * 2013105084 임영규
 *
 *
 *
 * */

package com.example.dudrb.weatherapitest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dudrb.weatherapitest.CityTour.TourMain;
import com.example.dudrb.weatherapitest.MedicalOrganization.MedicalOrg;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.MedicalOrgEng;
import com.example.dudrb.weatherapitest.Weather.WeatherActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick_main(View v){
        switch(v.getId())
        {
            case R.id.btn_city_1:
                startActivity(new Intent(this, MedicalOrg.class));
                break;
            case R.id. btn_2:
                startActivity(new Intent(this, MedicalOrgEng.class));
                break;
            case R.id. btn_3:
                startActivity(new Intent(this, TourMain.class));
                break;
            case R.id. btn_5:
                startActivity(new Intent(this, WeatherActivity.class));
                break;

        }
    }
}
