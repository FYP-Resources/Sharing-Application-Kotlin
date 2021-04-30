package com.hhdeveloper.sharingapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hhdeveloper.sharingapplication.databinding.ListSelectAudioBinding
import com.hhdeveloper.sharingapplication.datasource.data.AudioData

class SelectAudioAdapter: ListAdapter<AudioData,SelectAudioAdapter.ViewHolder>(SelectAudioDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=getItem(position)
        holder.bind(currentItem)
    }


    class ViewHolder private constructor(val binding:ListSelectAudioBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(
        currentItem: AudioData
        ) {
            binding.include.sizeText.text = currentItem.sizeIndex
        }
        companion object {
             fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    ListSelectAudioBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }
}
class SelectAudioDiffCallBack:DiffUtil.ItemCallback<AudioData>(){
    override fun areItemsTheSame(oldItem: AudioData, newItem: AudioData): Boolean {
        return oldItem.idIndex==newItem.idIndex
    }

    override fun areContentsTheSame(oldItem: AudioData, newItem: AudioData): Boolean {
        return oldItem==newItem
    }
}