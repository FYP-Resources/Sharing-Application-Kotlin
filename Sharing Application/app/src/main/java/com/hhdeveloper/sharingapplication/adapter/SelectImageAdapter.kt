package com.hhdeveloper.sharingapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hhdeveloper.sharingapplication.databinding.ListSelectImageBinding
import com.hhdeveloper.sharingapplication.datasource.data.ImageData
import com.hhdeveloper.sharingapplication.utils.Constant.TAG

class SelectImageAdapter(val context: Context):RecyclerView.Adapter<SelectImageAdapter.ViewHolder>(){
    var imagesList= listOf<ImageData>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListSelectImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = imagesList[position]
        Log.d(TAG,"In adapter ${imagesList.size}")
        Glide.with(context).asBitmap().load(currentItem.uri).into(holder.binding.image)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }
    class ViewHolder(val binding:ListSelectImageBinding):RecyclerView.ViewHolder(binding.root)
}