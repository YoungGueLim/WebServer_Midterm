package com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.dudrb.weatherapitest.Http.HttpReader_eng;
import com.example.dudrb.weatherapitest.MedicalOrganization.Medical;
import com.example.dudrb.weatherapitest.MedicalOrganization.MedicalList;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreAcitivityEng.AestheticEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreAcitivityEng.AllEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreAcitivityEng.OrientalEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreAcitivityEng.University;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreAestheticEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreAllInfoEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreAllTitleEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreDentalEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreDermaEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreHosUnivEng;
import com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store.StoreEnglish.StoreOrientalEng;
import com.example.dudrb.weatherapitest.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class MedicalOrgEng extends Activity {

    MedicdalListEng medicalList2;

    StoreAllInfoEng storeAllInfoEng;
    StoreAllTitleEng storeAllTitleEng;
    StoreDentalEng storeDentalEng;
    StoreDermaEng storeDermaEng;
    StoreHosUnivEng storeHosUnivEng;
    StoreOrientalEng storeOrientalEng;
    StoreAestheticEng storeAestheticEng;

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
        setContentView(R.layout.activity_medical_org_eng);

        medicalList2 = new MedicdalListEng();
        Thread thread ;
        thread = new Thread(){
      //  new Thread(){
            public void run(){
                int i;
                String str;
                HttpReader_eng hr = new HttpReader_eng();

                str = hr.sendByHttp("http://data.daegu.go.kr/hub/meditourleadorganeng.html?Type=json&key=7eb0522a66064d6c83b8d0a7e61c6724");

                Log.d("json", str);
                String temp = "";

                try{
                    JSONObject jobj = new JSONObject(str);
                    JSONArray jsonAry_title = jobj.getJSONArray("meditourleadorganeng");
                    JSONArray jsonAry_row = ((JSONObject)jsonAry_title.get(1)).getJSONArray("row");

                    for(i=0; i < jsonAry_row.length(); i++) {

                        MedicalEng medical2 = new MedicalEng();

                        medical2.setINST_TM(((JSONObject) jsonAry_row.get(i)).getString("INST_NM"));
                        medical2.setADR(((JSONObject) jsonAry_row.get(i)).getString("ADR"));
                        medical2.setTLNO(((JSONObject) jsonAry_row.get(i)).getString("TLNO"));
                        medical2.setHP(((JSONObject) jsonAry_row.get(i)).getString("HP"));
                        medical2.setEML(((JSONObject) jsonAry_row.get(i)).getString("EML"));
                        medical2.setMXT_SBJ(((JSONObject) jsonAry_row.get(i)).getString("MXT_SBJ"));
                        medical2.setMAX_HR(((JSONObject) jsonAry_row.get(i)).getString("MXT_HR"));

                        medicalList2.addList(medical2);

                        String strr = medical2.getINST_TM();

                        boolean hosuniv1 = strr.contains("Hospital");
                        boolean hosuniv2 = strr.contains("University");
                        boolean hosuniv3 = strr.contains("university");
                        boolean housuniv4 = strr.contains("hospital");
                        boolean surgery = strr.contains("Plastic");
                        boolean aesthetic = strr.contains("Aesthetic");
                        boolean oriental = strr.contains("Oriental");
                        boolean dental = strr.contains("Dental");
                        boolean derma = strr.contains("Dermatology");

                        ///////////// 카테고리에 맞게 저장 ////////////////
                        storeAllInfoEng.setStore_allinfo(strr + "\n");
                        if(medical2.getINST_TM().contains("Hospital")) {
                            storeHosUnivEng.setHouUnivEng(medicalList2.getMedicalArray().get(i).getINST_TM() + "\n");
                        }
                        if(oriental == true) {
                            storeOrientalEng.setOriental(strr + "\n");
                        }
                        if(derma == true) {
                            storeDermaEng.setDerma(strr + "\n");
                        }if(dental == true) {
                            storeDentalEng.setDental(strr + "\n");
                        }if(surgery == true ||aesthetic==true) {
                            storeAestheticEng.setAesthetic(strr + "\n\n");
                        }if(surgery==true){

                        }

                        Log.d("For 제목", medicalList2.getMedicalArray().get(i).getINST_TM());

                        storeAllInfoEng.setStore_allinfo(
                                "Org Title : " + medicalList2.getMedicalArray().get(i).getINST_TM() + "\n\n" +
                                        "Address : " + medicalList2.getMedicalArray().get(i).getADR() + "\n\n" +
                                        "Phone : " + medicalList2.getMedicalArray().get(i).getTLNO() + "\n\n" +
                                        "H.P : " + medicalList2.getMedicalArray().get(i).getHP() + "\n\n" +
                                        "Email : " + medicalList2.getMedicalArray().get(i).getEML() + "\n\n" +
                                        "Clinics : " + medicalList2.getMedicalArray().get(i).getMXT_SBJ() + "\n\n" +
                                        "Time : " + medicalList2.getMedicalArray().get(i).getMAX_HR() + "\n\n\n"
                        );
                       storeAllTitleEng.setAllTitleEng(medicalList2.getMedicalArray().get(i).getINST_TM());

                    }// for

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
       // thread.stop();

        for(int j=0; j < medicalList2.getMedicalArray().size(); j++) {
            if(medicalList2.getMedicalArray().get(j).getINST_TM().contains("Hospital") || medicalList2.getMedicalArray().get(j).getINST_TM().contains("University")) {
                temp_univ += medicalList2.getMedicalArray().get(j).getINST_TM() + "\n";
            }if(medicalList2.getMedicalArray().get(j).getINST_TM().contains("Oriental")){
                temp_oriental += medicalList2.getMedicalArray().get(j).getINST_TM() + "\n";
            }if(medicalList2.getMedicalArray().get(j).getINST_TM().contains("Dental")) {
                temp_dental += medicalList2.getMedicalArray().get(j).getINST_TM() + "\n";
            }if(medicalList2.getMedicalArray().get(j).getINST_TM().contains("Dermatology")||
                    medicalList2.getMedicalArray().get(j).getINST_TM().contains("Skin")||
                    medicalList2.getMedicalArray().get(j).getINST_TM().contains("Aesthetic")) {
                temp_derma += medicalList2.getMedicalArray().get(j).getINST_TM() + "\n";
            }
            temp_all += medicalList2.getMedicalArray().get(j).getINST_TM() + "\n";


            Log.d("All Info",storeAllInfoEng.getStore_allinfo().toString());

        }
        result_univ = temp_univ;
        result_dental = temp_dental;
        result_derma = temp_derma;
        result_oriental = temp_oriental;
        result_all  = temp_all;

    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn1_detail_eng: // 상세
                startActivity(new Intent(this,MedicdalDetailEng.class));
                break;

            case R.id.btn_1_oriental: // 한의원
                startActivity(new Intent(this,OrientalEng.class));
                break;

            case R.id.btn1_derma_eng: // 피부과
                startActivity(new Intent(this,AestheticEng.class));
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
