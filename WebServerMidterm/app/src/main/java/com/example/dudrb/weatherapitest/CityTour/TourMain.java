package com.example.dudrb.weatherapitest.CityTour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.dudrb.weatherapitest.Http.HttpReader_Tour;
import com.example.dudrb.weatherapitest.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class TourMain extends Activity {

    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15;

    TourList tourlist_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_main);

        tourlist_main = new TourList();

        bt1 = (Button) findViewById(R.id.btn_city_1);
        bt2 = (Button) findViewById(R.id.btn_city_2);
        bt3 = (Button) findViewById(R.id.btn_city_3);
        bt4 = (Button) findViewById(R.id.btn_tour_4);
        bt5 = (Button) findViewById(R.id.btn_city_5);
        bt6 = (Button) findViewById(R.id.btn_city_6);
        bt7 = (Button) findViewById(R.id.btn_city_7);
        bt8 = (Button) findViewById(R.id.btn_city_8);
        bt9 = (Button) findViewById(R.id.btn_city_9);
        bt10 = (Button) findViewById(R.id.btn_city_10);
        bt11 = (Button) findViewById(R.id.btn_city_11);
        bt12 = (Button) findViewById(R.id.btn_city_12);
        bt13 = (Button) findViewById(R.id.btn_city_3);
        bt14 = (Button) findViewById(R.id.btn_city_14);
        bt15 = (Button) findViewById(R.id.btn_city_15);

        Thread t1;

        t1 = new Thread(){
            public void run(){
                int i;
                String str;
                HttpReader_Tour hr = new HttpReader_Tour();

                str = hr.sendByHttp("http://data.daegu.go.kr/hub/facilitycitytourbus.html?key=1ba9f59967ca46a09cc6233dfe1ddb65&Type=json");

                Log.d("json", str);
                String temp = "";

                try{
                    JSONObject jobj = new JSONObject(str);
                    JSONArray jsonAry_title = jobj.getJSONArray("facilitycitytourbus");
                    JSONArray jsonAry_row = ((JSONObject)jsonAry_title.get(1)).getJSONArray("row");

                    for(i=0; i < 15; i++) {

                        Tour tour = new Tour();

                        tour.setDS(((JSONObject) jsonAry_row.get(i)).getString("DS"));
                        tour.setDRV_COURCE(((JSONObject) jsonAry_row.get(i)).getString("DRV_COURCE"));

                        tour.setDRV_1(((JSONObject) jsonAry_row.get(i)).getString("DRV_1") + "\n");
                        tour.setDRV_2(((JSONObject) jsonAry_row.get(i)).getString("DRV_2") + "\n");
                        tour.setDRV_3(((JSONObject) jsonAry_row.get(i)).getString("DRV_3") + "\n");
                        tour.setDRV_4(((JSONObject) jsonAry_row.get(i)).getString("DRV_4") + "\n");
                        tour.setDRV_5(((JSONObject) jsonAry_row.get(i)).getString("DRV_5") + "\n");

                        tour.setDRV_6(((JSONObject) jsonAry_row.get(i)).getString("DRV_6") + "\n");
                        tour.setDRV_7(((JSONObject) jsonAry_row.get(i)).getString("DRV_7") + "\n");
                        tour.setDRV_8(((JSONObject) jsonAry_row.get(i)).getString("DRV_8") + "\n");
                        tour.setDRV_9(((JSONObject) jsonAry_row.get(i)).getString("DRV_9") + "\n");
                        tour.setDRV_10(((JSONObject) jsonAry_row.get(i)).getString("DRV_10") + "\n");

                        tour.setDRV_11(((JSONObject) jsonAry_row.get(i)).getString("DRV_11") + "\n");
                        tour.setDRV_12(((JSONObject) jsonAry_row.get(i)).getString("DRV_12") + "\n");

                        tourlist_main.listAdd(tour);

                    }// for

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        t1.start();

    }

    public void onClick(View v){

        switch (v.getId()) {

            case R.id.btn_city_1:
                Intent intent = new Intent(this,TourInfo1.class);
                intent.putExtra("TourFlag",1);
                startActivity(intent);
                break;
            case R.id.btn_city_2:
                Intent intent2 = new Intent(this,TourInfo1.class);
                intent2.putExtra("TourFlag", 2);
                startActivity(intent2);
                break;
            case R.id.btn_city_3:
                Intent intent3 = new Intent(this,TourInfo1.class);
                intent3.putExtra("TourFlag",3);
                startActivity(intent3);
                break;
            case R.id.btn_tour_4:
                Intent intent4 = new Intent(this,TourInfo1.class);
                intent4.putExtra("TourFlag",4);
                startActivity(intent4);
                break;
            case R.id.btn_city_5:
                Intent intent5 = new Intent(this,TourInfo1.class);
                intent5.putExtra("TourFlag",5);
                startActivity(intent5);
                break;
            case R.id.btn_city_6:
                Intent intent6 = new Intent(this,TourInfo1.class);
                intent6.putExtra("TourFlag",6);
                startActivity(intent6);
                break;
            case R.id.btn_city_7:
                Intent intent7 = new Intent(this,TourInfo1.class);
                intent7.putExtra("TourFlag",7);
                startActivity(intent7);
                break;
            case R.id.btn_city_8:
                Intent intent8 = new Intent(this,TourInfo1.class);
                intent8.putExtra("TourFlag",8);
                startActivity(intent8);
                break;
            case R.id.btn_city_9:
                Intent intent9 = new Intent(this,TourInfo1.class);
                intent9.putExtra("TourFlag",9);
                startActivity(intent9);
                break;
            case R.id.btn_city_10:
                Intent intent10 = new Intent(this,TourInfo1.class);
                intent10.putExtra("TourFlag",10);
                startActivity(intent10);
                break;
            case R.id.btn_city_11:
                Intent intent11 = new Intent(this,TourInfo1.class);
                intent11.putExtra("TourFlag",11);
                startActivity(intent11);
                break;
            case R.id.btn_city_12:
                Intent intent12 = new Intent(this,TourInfo1.class);
                intent12.putExtra("TourFlag",12);
                startActivity(intent12);
                break;
            case R.id.btn_city_13:
                Intent intent13 = new Intent(this,TourInfo1.class);
                intent13.putExtra("TourFlag",13);
                startActivity(intent13);
                break;
            case R.id.btn_city_14:
                Intent intent14 = new Intent(this,TourInfo1.class);
                intent14.putExtra("TourFlag4",14);
                startActivity(intent14);
                break;
            case R.id.btn_city_15: {
                Intent intent15 = new Intent(this,TourInfo1.class);
                intent15.putExtra("TourFlag", 15);
                startActivity(intent15);
                break;
            }
        }
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
