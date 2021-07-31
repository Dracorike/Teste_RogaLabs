package com.petruciostech.teste_rogalabs.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.petruciostech.teste_rogalabs.R
import com.petruciostech.teste_rogalabs.databinding.ActivityMainBinding
import com.petruciostech.teste_rogalabs.model.PostModel
import com.petruciostech.teste_rogalabs.recyclerview.PostRecyclerAdapter

class MainActivity : AppCompatActivity(), MainContract.View {

    override lateinit var presenter: MainPresenter
    private lateinit var bind:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        presenter = MainPresenter(this)
        presenter.start()

    }

    override fun populateRecyclerView(postList: List<PostModel>) {
        bind.recyclerListofPosts.apply {
            adapter = PostRecyclerAdapter(postList, this@MainActivity)
            layoutManager = LinearLayoutManager(applicationContext)
        }
        bind.mainProgressbar.visibility = View.GONE
    }

    override fun bindView() {
        bind.mainProgressbar.visibility = View.VISIBLE
        setSupportActionBar(bind.mainToolbar)
    }


}