package com.easyhao.micro.personnel.utils.ip;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IPv4Utils {

    public static String getIPv4() throws Exception {
        String sohu = "http://pv.sohu.com/cityjson";
        String inputLine = "";
        String read = "";

        URL url = new URL(sohu);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        while ((read = in.readLine()) != null) {
            inputLine += read;
        }
        //防止乱码
        inputLine = new String(inputLine.getBytes("ISO-8859-1"), "UTF-8");
        int start = inputLine.indexOf("{");
        int stop = inputLine.indexOf("}");
        String json = inputLine.substring(start, stop + 1);
        ReturnCitySN ipObj = new ObjectMapper().readValue(json, ReturnCitySN.class);
        return ipObj.getCip();
    }


}
