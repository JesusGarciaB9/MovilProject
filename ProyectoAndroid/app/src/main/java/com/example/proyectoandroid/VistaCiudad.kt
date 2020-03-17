package com.example.proyectoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import com.example.proyectoandroid.modelos.City
import com.example.proyectoandroid.databinding.FragmentVistaCiudadBinding
/**
 * A simple [Fragment] subclass.
 */
class VistaCiudad : Fragment() {
    lateinit var profMod: City
    lateinit var mBinding: FragmentVistaCiudadBinding
    lateinit var navCon: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //el context del vista ciudad es .VistaCiudad
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_vista_ciudad, container, false)
        return mBinding.root

    }

}
