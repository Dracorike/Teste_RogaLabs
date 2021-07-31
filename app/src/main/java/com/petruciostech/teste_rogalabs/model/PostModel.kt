package com.petruciostech.teste_rogalabs.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class PostModel(
    val userId:Int,
    val id:Int,
    val title:String,
    val body:String
):Parcelable