package com.example.dudrb.weatherapitest.MedicalOrganization.Store;

/**
 * Created by dudrb on 2016-04-21.
 */
public class StoreAllInfo {
    static String store_allinfo = "";

    public static String getStore_allinfo() {
        return store_allinfo;
    }

    public static void setStore_allinfo(String temp) {
        store_allinfo += temp + "\n";
    }


}
