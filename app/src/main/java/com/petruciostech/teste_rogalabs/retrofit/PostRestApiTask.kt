package com.petruciostech.teste_rogalabs.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostRestApiTask {
    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    private fun postProvider():Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retroFitApi():PostApi = postProvider().create(PostApi::class.java)
}