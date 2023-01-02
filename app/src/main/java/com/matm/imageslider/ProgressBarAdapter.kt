package com.matm.imageslider

import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView


class ProgressBarAdapter(private var imageModel: ArrayList<BannerModel>) :
    RecyclerView.Adapter<ProgressBarAdapter.ViewHolder>() {

    private var checkedPosition = -1


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val imageView: ProgressBar =itemView.findViewById<ProgressBar>(R.id.progressBar)

        private val display = imageView.context.resources.displayMetrics.widthPixels
        private val with = display/imageModel.size

        fun bind(bannerModel: BannerModel, position: Int) {
            imageView.layoutParams.width=with-32
            imageView.progress = 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.progress_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(imageModel[position],position)

        if (checkedPosition == -1) {
            holder.imageView.progress = 0

        } else {
            if (checkedPosition == position) {

               val obj = object :CountDownTimer(5000,10){
                    override fun onTick(p0: Long) {
                        //forward progress
                        val finishedSeconds: Long = 5000 - p0
                        val total = (finishedSeconds.toFloat() / 5000.toFloat() * 100.0).toInt()
                        holder.imageView.progress = total+10
                    }
                    override fun onFinish() {
                        holder.imageView.progress = 0
                    }
                }.start()
            } else {
               holder.imageView.progress = 0
            }
        }


    }

    override fun getItemCount(): Int = imageModel.size


    fun startProgressBar(position: Int){
        checkedPosition =position
        notifyItemChanged(position)
    }




}