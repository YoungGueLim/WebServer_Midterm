package com.example.dudrb.weatherapitest.MedicalOrganization;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dudrb.weatherapitest.Http.HttpReader_kor;
import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreAllInfo;
import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreAllTitle;
import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreDental;
import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreDerma;
import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreHospUniv;
import com.example.dudrb.weatherapitest.MedicalOrganization.Store.StoreOriental;
import com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity.All;
import com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity.Dental;
import com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity.Derma;
import com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity.HospUniv;
import com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity.MedicalDetail;
import com.example.dudrb.weatherapitest.MedicalOrganization.StoreActivity.Oriental;
import com.example.dudrb.weatherapitest.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class MedicalOrg extends Activity {

    TextView textView;

    Button btn_head;

    MedicalList medicalList;

    StoreHospUniv storeHospUniv;
    StoreOriental storeOriental;
    StoreDental storeDental;
    StoreDerma storeDerma;
    StoreAllTitle storeAll;
    StoreAllInfo storeAllInfo;

    String temp_univ;
    String temp_oriental;
    String temp_dental;
    String temp_derma;
    String temp_all;

    String result_univ = "";
    String result_oriental = "";
    String result_derma = "";
    String result_dental = "";
    String result_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_org_list);

        textView = (TextView)findViewById(R.id.textView);

        btn_head = (Button)findViewById(R.id.btn1_head);

        storeHospUniv = new StoreHospUniv();

        medicalList = new MedicalList();

        Thread t1;

        t1 = new Thread(){
            public void run(){
                int i;
                String str;
                HttpReader_kor hr = new HttpReader_kor();

                str = hr.sendByHttp("http://data.daegu.go.kr/hub/meditourleadorgan.html?Type=json&KEY=7229caf2d1874083968b631855563747");

                try{
                    JSONObject jobj = new JSONObject(str);
                    JSONArray jsonAry_title = jobj.getJSONArray("meditourleadorgan");
                    JSONArray jsonAry_row = ((JSONObject)jsonAry_title.get(1)).getJSONArray("row");

                    Log.d("length",""+jsonAry_row.length());
                    for(i=0; i < jsonAry_row.length(); i++) {

                        Medical medical = new Medical();

                        medical.setINST_TM(((JSONObject) jsonAry_row.get(i)).getString("INST_NM"));
                        medical.setADR(((JSONObject) jsonAry_row.get(i)).getString("ADR"));
                        medical.setTLNO(((JSONObject) jsonAry_row.get(i)).getString("TLNO"));
                        medical.setHP(((JSONObject) jsonAry_row.get(i)).getString("HP"));
                        medical.setEML(((JSONObject) jsonAry_row.get(i)).getString("EML"));
                        medical.setMXT_SBJ(((JSONObject) jsonAry_row.get(i)).getString("MXT_SBJ"));
                        medical.setMAX_HR(((JSONObject) jsonAry_row.get(i)).getString("MXT_HR"));

                        medicalList.addList(medical);

                        String strr = medical.getINST_TM();

                        boolean hosuniv = strr.contains("대학교");
                        boolean oriental = strr.contains("한의원");
                        boolean dental = strr.contains("치과");
                        boolean derma = strr.contains("피부");

                        ///////////// 카테고리에 맞게 저장 ////////////////

                        // 모든 제목
                        storeAll.setAll(strr + "\n");
                        if(hosuniv == true) {
                          //  storeHospUniv.setStore(strr + "\n");
                            storeHospUniv.setStore(medicalList.getMedicalArray().get(i).getINST_TM() + "\n");
                        }
                        if(oriental == true) {
                            storeOriental.setOriental(strr + "\n");
                        }
                        if(derma == true) {
                            storeDerma.setDerma(strr + "\n");
                        }if(dental == true) {
                            storeDental.setDental(strr + "\n");
                        }

                        Log.d("For 제목",medicalList.getMedicalArray().get(i).getINST_TM());

                        storeAllInfo.setStore_allinfo(
                                "기관명 : " + medicalList.getMedicalArray().get(i).getINST_TM() + "\n\n" +
                                        "주소 : " + medicalList.getMedicalArray().get(i).getADR() + "\n\n" +
                                        "연락처 : " + medicalList.getMedicalArray().get(i).getTLNO() + "\n\n" +
                                        "홈페이지 : " + medicalList.getMedicalArray().get(i).getHP() + "\n\n" +
                                        "이메일 : " + medicalList.getMedicalArray().get(i).getEML() + "\n\n" +
                                        "진료과목 : " + medicalList.getMedicalArray().get(i).getMXT_SBJ() + "\n\n" +
                                        " 진료시간 : " + medicalList.getMedicalArray().get(i).getMAX_HR() + "\n\n\n"
                        );

                    }// for

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        for(int j=0; j < medicalList.getMedicalArray().size(); j++) {
            if(medicalList.getMedicalArray().get(j).getINST_TM().contains("대학교")) {
                temp_univ += medicalList.getMedicalArray().get(j).getINST_TM() + "\n";
            }if(medicalList.getMedicalArray().get(j).getINST_TM().contains("한의원")){
                temp_oriental += medicalList.getMedicalArray().get(j).getINST_TM() + "\n";
            }if(medicalList.getMedicalArray().get(j).getINST_TM().contains("치과")) {
                temp_dental += medicalList.getMedicalArray().get(j).getINST_TM() + "\n";
            }if(medicalList.getMedicalArray().get(j).getINST_TM().contains("피부")) {
                temp_derma += medicalList.getMedicalArray().get(j).getINST_TM() + "\n";
            }
                temp_all += medicalList.getMedicalArray().get(j).getINST_TM() + "\n";

        }
        result_univ = temp_univ;
        result_dental = temp_dental;
        result_derma = temp_derma;
        result_oriental = temp_oriental;
        result_all  = temp_all;

    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn1_head:
                startActivity(new Intent(this,HospUniv.class));
                break;
            case R.id.btn1_dental:
                startActivity(new Intent(this,Dental.class));
                break;
            case R.id.btn_1_oriental:
                startActivity(new Intent(this,Oriental.class));
                break;
            case R.id.btn1_derma:
                startActivity(new Intent(this,Derma.class));
                break;
            case R.id.btn1_else:
                startActivity(new Intent(this,All.class));
                break;
            case R.id.btn1_detail:
                startActivity(new Intent(this,MedicalDetail.class));
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
