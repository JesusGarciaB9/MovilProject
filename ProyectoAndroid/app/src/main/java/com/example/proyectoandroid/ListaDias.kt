package com.example.proyectoandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.proyectoandroid.databinding.FragmentVistaDiaBinding
import com.example.proyectoandroid.modelos.City
import com.example.proyectoandroid.modelos.Dias
import kotlinx.android.synthetic.main.fragment_lista_dias.view.*
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class ListaDias : Fragment()  ,DiaRecyclerViewAdapter.OnListInteraction  {
    lateinit var navCon: NavController
    private val userList = mutableListOf<Dias>()
    private var adapter: DiaRecyclerViewAdapter? = null
    lateinit var profMod: City
    lateinit var mBinding: FragmentVistaDiaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_lista_dias, container, false)


        adapter = DiaRecyclerViewAdapter(userList, this)
        view.list2.layoutManager = LinearLayoutManager(context)
        view.list2.adapter = adapter
        Log.d("DAYI2", "DAYI3")

        profMod = arguments!!.getParcelable("data")!!

        var coord = profMod.latitude+","+profMod.longitude
        var url = profMod.url
        Log.d("COORD", " CORDI  "+coord)

        VolleySingleton.getInstance(activity!!.applicationContext)
            .addToRequestQueue(getJsonObjectRequest(coord,url))

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navCon = Navigation.findNavController(view)


    }
    private fun parseObjectG(response: JSONObject,url:String) {
        Log.d("DAYI2", " LLEGO A OBJECT G")
        var list = Dia.getUser(response)


        for (element in list) {
            Log.d("DAYI22", "parseObjectG " +url)
            userList.add(
                Dias(
                   element.date.toString(),
                    "Hora del amanecer: "+element.sunrise_time.toString(),
                    element.temp_min_c.toString()+" - "+element.temp_max_c.toString()+"°C",
                    "Probabilidad de precipitaciones: "+element.prob_precip_pct.toString(),
                    "Hora de atardecer: "+element.sunset_time.toString(),
                                ""+url
                )
            )
        }
        adapter!!.notifyDataSetChanged()
    }
    private fun getJsonObjectRequest(coord:String,url2:String): JsonObjectRequest {
        // val url = "https://randomuser.me/api/?results=10"
        val url  ="http://api.weatherunlocked.com/api/forecast/"+coord+"?app_id=51ca7eea&app_key=2810ebec59802513f477c961135ac475"

        return JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->

                parseObjectG(response,url2)
                Log.d("JSONo", response.toString())
            },
            Response.ErrorListener {

                Log.d("JSONB", "Algo no funciono xd :'v aiuda")
            }
        )
    }
    override fun onListItemInteraction(item: Dias?) {

        val bundle = bundleOf("data" to item)
        navCon!!.navigate(R.id.action_listaDias_to_vistaDetallada,bundle)
    }



}
