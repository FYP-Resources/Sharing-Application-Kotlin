package com.hhdeveloper.sharingapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hhdeveloper.sharingapplication.databinding.ListSelectAppBinding
import com.hhdeveloper.sharingapplication.datasource.data.AppData

class SelectAppAdapter:RecyclerView.Adapter<SelectAppAdapter.ViewHolder>() {
    var appList= listOf<AppData>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun getItemCount()=appList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=appList[position]
        holder.binding.appImage.setImageDrawable(currentItem.appIcon)
        holder.binding.textView2.text=currentItem.appName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListSelectAppBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    class ViewHolder(val binding: ListSelectAppBinding):RecyclerView.ViewHolder(binding.root)
}