package com.petruciostech.teste_rogalabs.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CommentModel(
    val postId:Int,
    val id:Int,
    val name:String,
    val email:String,
    val body:String
):Parcelable