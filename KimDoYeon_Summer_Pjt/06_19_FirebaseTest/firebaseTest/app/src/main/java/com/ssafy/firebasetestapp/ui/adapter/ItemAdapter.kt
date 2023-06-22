package com.ssafy.firebasetestapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ssafy.firebasetestapp.data.Test
import com.ssafy.firebasetestapp.databinding.ItemBinding

class ItemAdapter(var items:MutableList<Test>, var context :Context):RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    inner class ViewHolder(var binding:ItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun setData(data:Test){
            binding.itemTextView.setText(data.content)
            Glide.with(context).load(data.imageUrl).into(binding.itemImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(items[position])
    }
}