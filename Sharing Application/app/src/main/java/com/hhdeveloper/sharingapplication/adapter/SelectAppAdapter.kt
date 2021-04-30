package com.hhdeveloper.sharingapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hhdeveloper.sharingapplication.databinding.ListSelectAppBinding
import com.hhdeveloper.sharingapplication.datasource.data.AppData

class SelectAppAdapter:ListAdapter<AppData,SelectAppAdapter.ViewHolder>(SelectAppDiffCallBack()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=getItem(position)
        holder.bind(currentItem)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListSelectAppBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(
            currentItem: AppData
        ) {
            binding.appImage.setImageDrawable(currentItem.appIcon)
            binding.textView2.text = currentItem.appName
            binding.include.sizeText.text=currentItem.sizeIndex
        }
        companion object {
             fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    ListSelectAppBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

}
class SelectAppDiffCallBack:DiffUtil.ItemCallback<AppData>(){
    override fun areItemsTheSame(oldItem: AppData, newItem: AppData): Boolean {
        return oldItem.appPackageName==newItem.appPackageName
    }

    override fun areContentsTheSame(oldItem: AppData, newItem: AppData): Boolean {
        return oldItem==newItem
    }
}