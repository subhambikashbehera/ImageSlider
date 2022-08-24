package com.matm.imageslider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageSliderAdapter(var bannerList: ArrayList<BannerModel>) :
    RecyclerView.Adapter<ImageSliderAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView =itemView.findViewById<ImageView>(R.id.imageView)
        fun bind(bannerModel: BannerModel) {
            Glide.with(imageView.context).load(bannerModel.bannerImage).into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.banner_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(bannerList[position])
    }

    override fun getItemCount(): Int = bannerList.size
}