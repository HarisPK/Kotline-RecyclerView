package com.example.muhammedharis.kotlinstudy

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick


/**
 * Created by muhammed haris on 24-01-2018.
 */
class MyAndroidAdapter(val userList: List<MyAndroidOS>, val itemClick: (String) -> Unit) : RecyclerView.Adapter<MyAndroidAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAndroidAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyAndroidAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position], itemClick)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: MyAndroidOS, itemClick: (String) -> Unit){
            itemView.textView.text = user.name
            itemView.imageView.setBackgroundResource(user.imageIcon)
            itemView.onClick { itemClick(user.name) }

        }
    }
}