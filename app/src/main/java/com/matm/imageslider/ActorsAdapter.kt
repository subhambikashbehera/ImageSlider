package com.matm.imageslider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ActorsAdapter:RecyclerView.Adapter<ActorsAdapter.MyViewHolder>() {

    val callBack = object :DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
           return oldItem==newItem
        }

    }

    val differ=AsyncListDiffer(this,callBack)

    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind(s: String?, position: Int) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.actors_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(differ.currentList[position],position)
    }

    override fun getItemCount(): Int = differ.currentList.size

}