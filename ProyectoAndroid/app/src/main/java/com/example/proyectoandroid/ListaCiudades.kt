package com.example.proyectoandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoandroid.modelos.City
import kotlinx.android.synthetic.main.fragment_lista_ciudades.view.*
import java.lang.Integer.signum

/**
 * A simple [Fragment] subclass.
 */
class ListaCiudades : Fragment(), CityRecyclerViewAdapter.OnListInteraction  {

    lateinit var viewModel: CiudadViewModel
    private var ciudadList = mutableListOf<Ciudad>()
    private val ciudadList2 = mutableListOf<City>()
    private var adapter: CityRecyclerViewAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
         savedInstanceState: Bundle?

    ): View? {

        viewModel = ViewModelProvider(this).get(CiudadViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_lista_ciudades, container, false)

        adapter = CityRecyclerViewAdapter(ciudadList2, this)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter




        viewModel.getCity().observe(viewLifecycleOwner, Observer{
                Citys  -> run {
            if (ciudadList.size <= 10) {
               var count = 0
            ciudadList =  Citys as MutableList<Ciudad>
            Log.d("videovolley","user list size "+ciudadList.size )
                if (ciudadList.size == 10) {
                for (element in ciudadList){
                    count++
                    var tempe = 0xff000000.toInt()
                        val lower = 0xff035efc.toInt()
                        val higher = 0xfffc3903.toInt()
                    val cat = element.temperatura.substring(0,element.temperatura.length-2).toDouble()
                    tempe = when {
                        cat <= 10 -> {
                            lower
                        }
                        cat >= 30 -> {
                            higher
                        }
                        else -> {
                            val red:Double = when {
                                cat <= 20 ->{
                                    0x3 + (0xfc-0x3)*((cat-10)/10)
                                }
                                else ->{
                                    0xfc.toDouble()
                                }
                            }
                            val green = when {
                                cat <=20 ->{
                                    0x84 + (0xfc-0x84)*((cat-10)/10)
                                }
                                else ->{
                                    0xfc + (0x35-0xfc)*((cat-20)/10)
                                }
                            }
                            val blue = when{
                                cat <=20 ->{
                                    0xfc + (0x07-0xfc)*(cat-10/10)
                                }else ->{
                                    0x07 + (0x03-0x07)*(cat-20/10)
                                }
                            }
                            val x = lower shl 8
                            (red.toInt() shl 16)+(green.toInt() shl 8)+blue.toInt()+0xFF000000.toInt()
                        }
                    }
                    ciudadList2.add(
                        City(
                            element.NombreCiudad.toString(),
                            element.temperatura.toString(),
                            element.latitude.toString(),
                            element.longitude.toString(),
                            element.url.toString(),
                            tempe
                        )
                    )

                }
                    adapter!!.notifyDataSetChanged()
            }

            }


        }
        })

        viewModel.addcity()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navCon = Navigation.findNavController(view)



    }
    lateinit var navCon: NavController
    override fun onListItemInteraction(item: City?) {
      val bundle = bundleOf("data" to item)
        navCon!!.navigate(R.id.action_listaCiudades_to_listaDias,bundle)
    }


}
