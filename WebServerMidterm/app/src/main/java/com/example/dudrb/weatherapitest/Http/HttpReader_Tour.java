package com.example.dudrb.weatherapitest.Http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dudrb on 2016-04-21.
 */
public class HttpReader_Tour {

    public String sendByHttp(String urlStr){
        URL url = null;
        HttpURLConnection connection = null;

        try{
            url = new URL(urlStr);
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            connection = (HttpURLConnection)url.openConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        BufferedReader br = null;

        try{
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }

        String result = "";
        String line = "";

        try{
            while( (line = br.readLine()) != null)
            {
                result += line;
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
