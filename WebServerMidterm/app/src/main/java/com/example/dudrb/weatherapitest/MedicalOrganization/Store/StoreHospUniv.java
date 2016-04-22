package com.example.dudrb.weatherapitest.MedicalOrganization.Store;

/**
 * Created by dudrb on 2016-04-20.
 */
public class StoreHospUniv {

   static String hospUniv = "" ;

    public String getStore() {
        return hospUniv;
    }

    public void setStore(String temp) {
        hospUniv += temp + "\n";
    }

}
