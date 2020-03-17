package com.example.proyectoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.proyectoandroid.databinding.FragmentVistaDiaBinding
import com.example.proyectoandroid.modelos.City

/**
 * A simple [Fragment] subclass.
 */
class VistaDia : Fragment() {
    lateinit var profMod: City
    lateinit var mBinding: FragmentVistaDiaBinding
    lateinit var navCon: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vista_dia, container, false)
    }

}
