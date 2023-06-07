package com.ssafy.likedislike.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.likedislike.data.CardItem
import com.ssafy.likedislike.databinding.CardItemBinding

class CardStackAdapter(var items : MutableList<CardItem>):RecyclerView.Adapter<CardStackAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position:Int){
        holder.setData(items[position])
    }

    inner class ViewHolder(var binding:CardItemBinding):RecyclerView.ViewHolder(binding.root){
        fun setData(data: CardItem){
            binding.cardItem=data
        }
    }
}