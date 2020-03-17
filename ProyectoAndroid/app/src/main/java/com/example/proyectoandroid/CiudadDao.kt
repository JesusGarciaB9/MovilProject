package com.example.proyectoandroid

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class CiudadDao private constructor(var context: Context) {
    private val ciudades = MutableLiveData<List<Ciudad>>()
    private val listaciudad = mutableListOf<Ciudad>()
    private var queue : RequestQueue
    init{
        queue = VolleySingleton.getInstance(context).requestQueue
    }
    companion object{
        @Volatile
        private var INSTANCE :CiudadDao? = null
        fun getInstance(context: Context) =
            INSTANCE?: synchronized(this){
                INSTANCE?:CiudadDao(context).also{INSTANCE = it}
            }
    }
    fun addCity(){
        val coord = arrayOf("4.61,-74.08","6.25,-75.56","3.43,-76.52","10.97,-74.78","10.40,-75.51","7.90,-72.50","7.12,-73.11","10.92,-74.76","4.44,-75.23","4.81,-75.69")

        for (num in coord) {

            VolleySingleton.getInstance(context).addToRequestQueue(getJsonObjectRequest(num))
        }
    }

    fun getCitys() = ciudades

    private fun getJsonObjectRequest(coord:String ): JsonObjectRequest {

            val url =
                "http://api.weatherunlocked.com/api/current/"+coord+"?app_id=51ca7eea&app_key=2810ebec59802513f477c961135ac475"

            return JsonObjectRequest(
                Request.Method.GET, url, null,
                Response.Listener { response ->

                    parseObjectG(response,coord)
                    Log.d("JSONo", response.toString())
                },
                Response.ErrorListener {

                    Log.d("JSONB", "Algo no funciono xd :'v aiuda")
                }
            )



    }




    private fun parseObjectG(response: JSONObject,coord:String) {
        Log.d("DAYI2", " LLEGO A OBJECT G")
        var list = Ciudad.getUser(response,coord)

        for (element in list) {
             Log.d("DAYI4", "parseObjectG " +element.latitude.toString())
             Log.d("DAYI4", "parseObjectG " +element.longitude.toString())

          listaciudad.add(element )
        }
        ciudades.value = listaciudad

    }

}