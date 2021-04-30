package com.hhdeveloper.sharingapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.ListSelectVideoBinding
import com.hhdeveloper.sharingapplication.datasource.data.VideoData
import com.hhdeveloper.sharingapplication.utils.Util.readableFileSize

class SelectVideoAdapter(private val context: Context) :ListAdapter<VideoData,SelectVideoAdapter.ViewHolder>(SelectVideoDiffCallBack()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem,context)
    }

    class ViewHolder private constructor(private val binding:ListSelectVideoBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: VideoData, context: Context) {
            binding.include.sizeText.text=currentItem.sizeIndex
            Glide
                .with(context)
                .load(currentItem.uri)
                .placeholder(R.drawable.ic_color_video_logo)
                .into(binding.videoThumbnail)
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    ListSelectVideoBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }
}
class SelectVideoDiffCallBack:DiffUtil.ItemCallback<VideoData>(){
    override fun areItemsTheSame(oldItem: VideoData, newItem: VideoData): Boolean {
        return oldItem.idIndex==newItem.idIndex
    }

    override fun areContentsTheSame(oldItem: VideoData, newItem: VideoData): Boolean {
        return oldItem==newItem
    }
}
