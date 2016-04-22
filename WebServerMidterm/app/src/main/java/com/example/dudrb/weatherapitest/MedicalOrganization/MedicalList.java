package com.example.dudrb.weatherapitest.MedicalOrganization;

import java.util.ArrayList;

/**
 * Created by dudrb on 2016-04-15.
 */
public class MedicalList {

    static ArrayList<Medical> medicalArray = new ArrayList<>();


    public ArrayList<Medical> getMedicalArray() {
        return medicalArray;

    }

    public void setMedicalArray(ArrayList<Medical> medicalArray) {
        this.medicalArray = medicalArray;
    }

    public void addList(Medical medical){
        medicalArray.add(medical);
    }
}
