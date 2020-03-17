package com.example.proyectoandroid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class CiudadViewModel (application:Application):AndroidViewModel(application){

    private var ciudadDao : CiudadDao

    init {
        ciudadDao = CiudadDao.getInstance(this.getApplication())

    }
    fun addcity(){
        ciudadDao.addCity()
    }
    fun getCity() : MutableLiveData<List<Ciudad>> {

        return ciudadDao.getCitys()
    }
}