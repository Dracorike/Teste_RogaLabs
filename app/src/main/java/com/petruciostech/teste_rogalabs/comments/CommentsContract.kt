package com.petruciostech.teste_rogalabs.comments

import com.petruciostech.teste_rogalabs.model.CommentModel
import com.petruciostech.teste_rogalabs.mvp.BasePresenter
import com.petruciostech.teste_rogalabs.mvp.BaseView

interface CommentsContract {

    interface View:BaseView<CommentsPresenter>{
        fun init()
        fun getPostId():Int
        fun populateRecyclerView(commentsList:List<CommentModel>)
    }

    interface Presenter:BasePresenter{
        fun getAllComentsPost(idPost:Int)
    }


}