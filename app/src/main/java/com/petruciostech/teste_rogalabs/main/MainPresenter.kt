package com.petruciostech.teste_rogalabs.main

import com.petruciostech.teste_rogalabs.model.PostModel
import com.petruciostech.teste_rogalabs.retrofit.PostRestApiTask
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainContract.View): MainContract.Presenter {

    override fun getAllPost() {
        val call = PostRestApiTask().retroFitApi().getAllPosts()
        call.enqueue(object :Callback<List<PostModel>>{
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                response.body()?.let {
                    view.populateRecyclerView(it)
                }

            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }




    override fun start() {
        getAllPost()
        view.bindView()
    }
}