package com.petruciostech.teste_rogalabs.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.petruciostech.teste_rogalabs.R
import com.petruciostech.teste_rogalabs.comments.CommentsActivity
import com.petruciostech.teste_rogalabs.model.PostModel

class PostRecyclerAdapter(val postList: List<PostModel>, val context: Context):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item_recycler, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holderPost: PostViewHolder, position: Int) {
        holderPost.bind.textvTitle.text = postList[position].title
        holderPost.bind.textvBody.text = postList[position].body

        holderPost.itemView.setOnClickListener {
            val intent = Intent(context, CommentsActivity::class.java)
            intent.putExtra("post_id", postList[position].id)
            intent.putExtra("post_name", postList[position].title)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = postList.size
}