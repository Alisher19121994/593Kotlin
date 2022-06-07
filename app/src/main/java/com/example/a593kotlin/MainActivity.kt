package com.example.a593kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.main_recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        // recyclerView.layoutManager = StaggeredGridLayoutManager(1,2)
        getAdapter(data())

    }

    private fun data(): ArrayList<Main> {
        val list = ArrayList<Main>()
        val posts = ArrayList<Posts>()

        for (i in 0..4) {
            posts.add(Posts(R.drawable.ali))
        }
        for (i in 0..12) {
            list.add(Main(posts))
        }
        return list
    }

    private fun getAdapter(data: ArrayList<Main>) {
        val adapter = PostsAdapter(this, data)
        recyclerView.adapter = adapter
    }

}