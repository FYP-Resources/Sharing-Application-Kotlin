package com.hhdeveloper.sharingapplication.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.databinding.ListSelectImageBinding
import com.hhdeveloper.sharingapplication.datasource.data.ImageData
import com.hhdeveloper.sharingapplication.utils.Util.readableFileSize

class SelectImageAdapter(val context: Context):ListAdapter<ImageData,SelectImageAdapter.ViewHolder>(SelectImageDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem,context)
    }

    class ViewHolder private constructor(val binding: ListSelectImageBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            currentItem: ImageData,
            context: Context
        ) {
            binding.include.sizeText.text = currentItem.sizeIndex
            Glide
                .with(context)
                .asBitmap()
                .load(currentItem.uri)
                .placeholder(R.drawable.ic_color_image_logo)
                .into(binding.imageView)
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    ListSelectImageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

}
class SelectImageDiffCallBack:DiffUtil.ItemCallback<ImageData>(){
    override fun areItemsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
        return oldItem.idIndex==newItem.idIndex
    }

    override fun areContentsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
        return oldItem==newItem
    }
}