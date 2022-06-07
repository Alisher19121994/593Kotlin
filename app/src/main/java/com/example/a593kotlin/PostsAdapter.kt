package com.example.a593kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import java.util.*

import kotlin.collections.ArrayList

class PostsAdapter(var context: Context, var list: ArrayList<Main>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private fun photoAdapter(photo: ArrayList<Posts>, recyclerView: RecyclerView) {
        val adapter = PhotoAdapter(context, photo)
        recyclerView.adapter = adapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.posts, parent, false)
        return PhotoViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val main = list[position]

        if (holder is PhotoViewHolder) {
            val recyclerView = holder.recyclerView
            photoAdapter(main.posts, recyclerView)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PhotoViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val recyclerView: RecyclerView = item.findViewById(R.id.post_recyclerview)

        init {
            val snapHelper: SnapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        }
    }
}