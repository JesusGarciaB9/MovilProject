package com.example.proyectoandroid.modelos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class City (
    val nombreciudad: String,
    val temperatura: String,
    val latitude: String,
    val longitude: String,
    val url: String,
    val col: Int
    // val first_name: String,
    // val last_name: String,
    // val photo: Int,
    // val photoUrl: String,
    // val email : String,
    // val phone : String
) : Parcelable {
}