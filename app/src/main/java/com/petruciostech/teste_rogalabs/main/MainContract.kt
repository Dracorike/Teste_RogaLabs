package com.petruciostech.teste_rogalabs.main

import com.petruciostech.teste_rogalabs.model.PostModel
import com.petruciostech.teste_rogalabs.mvp.BasePresenter
import com.petruciostech.teste_rogalabs.mvp.BaseView

interface MainContract {

    interface View: BaseView<MainPresenter>{
        fun populateRecyclerView(postList: List<PostModel>)
        fun bindView()
    }

    interface Presenter:BasePresenter{
        fun getAllPost()
    }
}