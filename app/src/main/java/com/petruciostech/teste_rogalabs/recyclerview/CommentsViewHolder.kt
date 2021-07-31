package com.petruciostech.teste_rogalabs.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.petruciostech.teste_rogalabs.databinding.CommentItemRecyclerBinding

class CommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val bind = CommentItemRecyclerBinding.bind(itemView)
}