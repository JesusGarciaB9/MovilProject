package com.example.proyectoandroid.modelos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Dias (
    val date: String,
    val  sunrise_time: String,
    val temp_range:String,
    val prob_precip_pct: String,
    val sunset_time:String,
    val url: String
) : Parcelable {
}