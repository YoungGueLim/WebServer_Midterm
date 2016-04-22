package com.example.dudrb.weatherapitest.MedicalOrganization.Store;

/**
 * Created by dudrb on 2016-04-21.
 */
public class StoreDental {
    public static String getDental() {
        return dental;
    }

    public static void setDental(String dental) {
        StoreDental.dental += dental + "\n";
    }

    static String dental = "";

}
