package com.petruciostech.teste_rogalabs.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.petruciostech.teste_rogalabs.R
import com.petruciostech.teste_rogalabs.model.CommentModel

class CommentsRecyclerAdapter(private val listComments: List<CommentModel>)
    :RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comment_item_recycler, parent, false)
        return CommentsViewHolder(view)
    }

    override fun onBindViewHolder(holderComment: CommentsViewHolder, position: Int) {
        holderComment.bind.textvNameUser.text = listComments[position].name
        holderComment.bind.textvEmailUser.text = listComments[position].email
        holderComment.bind.textvBodyComment.text = listComments[position].body
    }

    override fun getItemCount(): Int = listComments.size
}