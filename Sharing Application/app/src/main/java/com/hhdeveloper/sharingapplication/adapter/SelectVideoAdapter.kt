package com.hhdeveloper.sharingapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hhdeveloper.sharingapplication.databinding.ListSelectVideoBinding
import com.hhdeveloper.sharingapplication.datasource.data.VideoData

class SelectVideoAdapter(private val context: Context) :RecyclerView.Adapter<SelectVideoAdapter.ViewHolder>() {
     var videoList= listOf<VideoData>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = videoList[position]
        holder.bind(currentItem,context)
    }

    override fun getItemCount(): Int = videoList.size

    class ViewHolder(private val view:ListSelectVideoBinding):RecyclerView.ViewHolder(view.root){
        fun bind(currentItem: VideoData,context: Context) {
            view.videoNameText.text = currentItem.albumIndex
            Glide.with(context).load(currentItem.uri).into(view.videoThumbnail)
        }
        companion object {
             fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(ListSelectVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }

}