package com.hhdeveloper.sharingapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hhdeveloper.sharingapplication.databinding.ListSelectVideoBinding
import com.hhdeveloper.sharingapplication.datasource.data.VideoData

class SelectVideoAdapter(val context: Context, val videoList: List<VideoData>) :RecyclerView.Adapter<SelectVideoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectVideoAdapter.ViewHolder {
        return ViewHolder(ListSelectVideoBinding.inflate(LayoutInflater.from(parent.context),parent,false  ) )
    }

    override fun onBindViewHolder(holder: SelectVideoAdapter.ViewHolder, position: Int) {
        val currentItem = videoList[position]
        holder.view.videoNameText.text = currentItem.albumIndex
        Glide.with(context).load(currentItem.uri).into(holder.view.videoThumbnail)
    }

    override fun getItemCount(): Int = videoList.size

    class ViewHolder(val view:ListSelectVideoBinding):RecyclerView.ViewHolder(view.root)
}