package com.example.proyectoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.proyectoandroid.databinding.FragmentVistaDetalladaBinding
import com.example.proyectoandroid.databinding.FragmentVistaDiaBinding
import com.example.proyectoandroid.modelos.Dias

/**
 * A simple [Fragment] subclass.
 */
class VistaDetallada : Fragment() {

    lateinit var navController: NavController
    lateinit var  Model: Dias
    lateinit var mBinding: FragmentVistaDetalladaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_vista_detallada, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
         Model = arguments!!.getParcelable("data")!!

        mBinding.dia =  Model

    }
}
