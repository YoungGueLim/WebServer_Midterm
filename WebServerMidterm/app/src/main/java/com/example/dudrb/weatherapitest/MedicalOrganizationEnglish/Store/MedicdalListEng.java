package com.example.dudrb.weatherapitest.MedicalOrganizationEnglish.Store;

import com.example.dudrb.weatherapitest.MedicalOrganization.Medical;

import java.util.ArrayList;

/**
 * Created by dudrb on 2016-04-21.
 */
public class MedicdalListEng {

    static ArrayList<MedicalEng> medicalArray2 = new ArrayList<>();


    public ArrayList<MedicalEng> getMedicalArray() {
        return medicalArray2;

    }

    public void setMedicalArray(ArrayList<MedicalEng> medicalArray) {
        this.medicalArray2 = medicalArray;
    }

    public void addList(MedicalEng medical){
        medicalArray2.add(medical);
    }
}
