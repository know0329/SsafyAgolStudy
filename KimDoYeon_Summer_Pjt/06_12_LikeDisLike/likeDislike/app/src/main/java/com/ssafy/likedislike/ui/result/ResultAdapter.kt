package com.ssafy.likedislike.ui.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.likedislike.data.CardItem
import com.ssafy.likedislike.databinding.CardItemBinding
import com.ssafy.likedislike.databinding.ResultItemBinding

class ResultAdapter(var items:ArrayList<CardItem>):RecyclerView.Adapter<ResultAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ResultItemBinding):RecyclerView.ViewHolder(binding.root){
        fun setData(data: CardItem){
            binding.resultItem=data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResultItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(items[position])
    }

}