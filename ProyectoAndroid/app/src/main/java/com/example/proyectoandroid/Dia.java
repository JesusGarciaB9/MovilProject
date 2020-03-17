package com.example.proyectoandroid;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dia{
    public static Gson g = new Gson();

    public String date;
    public String sunrise_time;
    public String temp_max_c;
    public String temp_min_c;
    public String prob_precip_pct;
    public String sunset_time;
    public String url;




    public static ArrayList<Dia> getUser(JSONObject response){
        ArrayList<Dia> list = new ArrayList<>();
        Log.d("DAYI", "LLEGO " );
        try {
            JSONArray info = response.getJSONArray("Days");

            for (int i = 0;i < info.length(); i++){
                String Dayi = info.getJSONObject(i).toString();
                Log.d("DAYI", "parseObjectG " + Dayi );
                Dia temp = g.fromJson(Dayi,Dia.class);
                list.add(temp);
            }
        }catch (JSONException e) {

        }
        return list;
    }



}
