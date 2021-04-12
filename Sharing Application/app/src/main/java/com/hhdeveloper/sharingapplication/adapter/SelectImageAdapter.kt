package com.hhdeveloper.sharingapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hhdeveloper.sharingapplication.databinding.ListSelectImageBinding
import com.hhdeveloper.sharingapplication.databinding.ListSelectVideoBinding
import com.hhdeveloper.sharingapplication.datasource.data.ImageData

class SelectImageAdapter(val context: Context, val imageList: List<ImageData>):RecyclerView.Adapter<SelectImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectImageAdapter.ViewHolder {
        return SelectImageAdapter.ViewHolder(ListSelectImageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: SelectImageAdapter.ViewHolder, position: Int) {
        val currentItem = imageList[position]
        holder.view.imageNameText.text = currentItem.albumIndex
        //holder.view.imageThumbnail.setImageURI(currentItem.uri)
        Glide.with(context).load(currentItem.uri).into(holder.view.imageThumbnail)
    }

    override fun getItemCount(): Int = imageList.size

    class ViewHolder(val view:ListSelectImageBinding):RecyclerView.ViewHolder(view.root)

}