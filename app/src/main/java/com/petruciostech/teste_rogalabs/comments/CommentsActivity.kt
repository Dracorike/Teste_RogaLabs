package com.petruciostech.teste_rogalabs.comments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.petruciostech.teste_rogalabs.R
import com.petruciostech.teste_rogalabs.databinding.ActivityCommentsBinding
import com.petruciostech.teste_rogalabs.model.CommentModel
import com.petruciostech.teste_rogalabs.recyclerview.CommentsRecyclerAdapter

class CommentsActivity : AppCompatActivity(), CommentsContract.View {
    override lateinit var presenter: CommentsPresenter
    private lateinit var bind:ActivityCommentsBinding
    private var post_id = 0
    private lateinit var post_name:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        bind = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(bind.root)
        presenter = CommentsPresenter(this)
        presenter.start()
    }

    override fun init() {
        val intent = intent
        post_id = intent.getIntExtra("post_id", 0)
        post_name = intent.getStringExtra("post_name") as String
        bind.commentsProgressBar.visibility = View.VISIBLE
        bind.textvTitleToolbar.text = "O que a gelera tá comentando sobre \n $post_name"
        setSupportActionBar(bind.commentToolbar)
    }

    override fun getPostId():Int = post_id

    override fun populateRecyclerView(commentsList: List<CommentModel>) {
        bind.recyclerComents.apply {
            adapter = CommentsRecyclerAdapter(commentsList)
            layoutManager = LinearLayoutManager(applicationContext)
        }
        bind.commentsProgressBar.visibility = View.GONE
    }
}