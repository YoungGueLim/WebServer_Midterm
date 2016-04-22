package com.example.dudrb.weatherapitest.MedicalOrganization.Store;

/**
 * Created by dudrb on 2016-04-21.
 */
public class StoreDerma {
    public static String getDerma() {
        return derma;
    }

    public static void setDerma(String derma) {
        StoreDerma.derma += derma + "\n";
    }

    static String derma = "";
}
