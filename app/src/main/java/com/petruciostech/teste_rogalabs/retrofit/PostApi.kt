package com.petruciostech.teste_rogalabs.retrofit

import com.petruciostech.teste_rogalabs.model.CommentModel
import com.petruciostech.teste_rogalabs.model.PostModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {

    //"https://jsonplaceholder.typicode.com/posts"
    @GET("posts")
    fun getAllPosts():Call<List<PostModel>>

    @GET("posts/{post_id}/comments")
    fun getCommentsPost(@Path("post_id") postId:Int):Call<List<CommentModel>>
}