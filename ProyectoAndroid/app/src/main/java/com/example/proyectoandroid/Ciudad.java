package com.example.proyectoandroid;

import android.graphics.Color;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ciudad {
    public static Gson g = new Gson();
    public String NombreCiudad;
    public String temperatura;
    public String latitude;
    public String longitude;
    public String url;
    public int col;


    public static ArrayList<Ciudad> getUser(JSONObject response, String coord){
        ArrayList<Ciudad> list = new ArrayList<>();
        Ciudad temp= new Ciudad();
        String nombre = "";
        String url = "";
        if (coord == "4.61,-74.08"){
            url  = "https://www.dw.com/image/51519703_303.jpg";
            nombre = "Bogotá";
        }else if(coord == "6.25,-75.56"){
            url  = "https://www.eltiempo.com/files/image_640_428/uploads/2019/05/24/5ce87af8f27e6.jpeg";
            nombre = "Medellín";
        }else if(coord == "3.43,-76.52"){
            url  = "https://www.eltiempo.com/files/image_640_428/uploads/2018/12/30/5c28ec219d4e1.jpeg";
            nombre = "Cali";
        }else if(coord == "10.97,-74.78"){
            url  = "https://www.las2orillas.co/wp-content/uploads/2019/11/ventana.png";
            nombre = "Barranquilla";
        }else if(coord == "10.40,-75.51"){
            url = "https://files.rcnradio.com/public/styles/image_834x569/public/2018-08/whatsapp_image_2018-08-24_at_7.17.47_am_0_1_0.jpeg?itok=uAgV-TdY";
            nombre =  "Cartagena";
        }else if(coord == "7.90,-72.50"){
            url = "https://www.colombiainforma.info/wp-content/uploads/2019/10/cucuta.jpg";
            nombre =   "Cúcuta";
        }else if(coord == "7.12,-73.11"){
            url = "https://admin.bluradio.com/sites/default/files/styles/blu_medium_650x466/public/foto_nueva_bucaramanga_oct_2.jpg?itok=ebDGu_ou";
            nombre =   "Bucaramanga";
        }else if(coord == "10.92,-74.76"){
            url = "https://m.eltiempo.com/files/image_640_428/uploads/2017/11/29/5a1eca4537563.jpeg";
            nombre =   "Soledad";
        }else if(coord == "4.44,-75.23"){
           url = "https://www.ecosdelcombeima.com/sites/default/files/g0013703.jpg";
            nombre =    "Ibagué";
        }else if(coord == "4.81,-75.69"){
         url = "https://rtvc-assets-radionica3.s3.amazonaws.com/s3fs-public/styles/image_750x424/public/field/image/article/skyline_pereira.jpg?itok=wz7zPvip";
            nombre =     "Pereira";
        }


        try {
            double  lat =    response.getDouble("lat");
            String latitude = Double.toString(lat);
            double  lon = response.getDouble("lon");
            String longitude = Double.toString(lon);
            double tempe =  response.getDouble("temp_c");
            String temperatura = Double.toString(tempe);
            Log.d("DAYI", "LLEGO con lat "+latitude+" y lon "+longitude );
            temp.NombreCiudad = nombre;
            temp.longitude = longitude;
            temp.latitude = latitude;
            temp.temperatura =temperatura+"°c";
            temp.url = url;
            temp.col = 0x000000;
            Log.d("URL1", "LLEGO "+url );
            list.add(temp);

        }catch (JSONException e) {

        }
        return list;
    }

    public static  Ciudad  getUser2(JSONObject response){
        Log.d("DAYI", "LLEGO9" );
        Ciudad ciu = new Ciudad();
        Log.d("DAYI", "LLEGO" );
        try {
            double  lat =    response.getDouble("lat");
            String latitude = Double.toString(lat);
            double  lon = response.getDouble("lon");
            String longitude = Double.toString(lon);
            Log.d("DAYI", "LLEGO con lat "+latitude+" y lon "+longitude );

        }catch (JSONException e) {

        }
          return ciu;
    }


}
