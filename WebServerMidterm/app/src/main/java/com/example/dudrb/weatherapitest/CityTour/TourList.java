package com.example.dudrb.weatherapitest.CityTour;

import java.util.ArrayList;

/**
 * Created by dudrb on 2016-04-21.
 */
public class TourList {

    static ArrayList<Tour> tourlist = new ArrayList<>();

    public ArrayList<Tour> getTourlist() {
        return tourlist;
    }

    public void setTourlist(ArrayList<Tour> tourlist) {
        this.tourlist = tourlist;
    }
    public void listAdd(Tour temp){
        tourlist.add(temp);
    }

}
