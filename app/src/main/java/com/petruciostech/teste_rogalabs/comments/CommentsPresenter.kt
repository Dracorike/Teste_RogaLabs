package com.petruciostech.teste_rogalabs.comments

import com.petruciostech.teste_rogalabs.model.CommentModel
import com.petruciostech.teste_rogalabs.retrofit.PostRestApiTask
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsPresenter(private val view:CommentsContract.View): CommentsContract.Presenter {
    override fun getAllComentsPost(idPost:Int) {
        val call = PostRestApiTask().retroFitApi().getCommentsPost(postId = idPost)
        call.enqueue(object :Callback<List<CommentModel>>{
            override fun onResponse(
                call: Call<List<CommentModel>>,
                response: Response<List<CommentModel>>
            ) {
                response.body()?.let { view.populateRecyclerView(it) }
            }

            override fun onFailure(call: Call<List<CommentModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


    override fun start() {
        view.init()
        getAllComentsPost(view.getPostId())
    }


}