package com.ssafy.likedislike.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.likedislike.data.CardItem
import com.ssafy.likedislike.databinding.ActivityResultBinding

private const val TAG = "ResultActivity"
class ResultActivity : AppCompatActivity() {
    lateinit var binding : ActivityResultBinding
    lateinit var likedAdapter: ResultAdapter
    lateinit var disLikedAdapter: ResultAdapter
    var likedList = arrayListOf<CardItem>()
    var disLikedList = arrayListOf<CardItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)

        setContentView(binding.root)

        likedAdapter = ResultAdapter(likedList)
        disLikedAdapter = ResultAdapter(disLikedList)

        binding.likedRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.disLikedRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.likedRecyclerView.adapter = likedAdapter
        binding.disLikedRecyclerView.adapter = disLikedAdapter


        if(intent.getSerializableExtra("liked")!=null){
            likedList.addAll( intent.getSerializableExtra("liked") as ArrayList<CardItem>)
            Log.d(TAG, "onCreate: ${likedList.size}")
            likedAdapter.notifyDataSetChanged()
        }
        if(intent.getSerializableExtra("disLiked")!=null){
            disLikedList.addAll( intent.getSerializableExtra("disLiked") as ArrayList<CardItem>)
            disLikedAdapter.notifyDataSetChanged()
        }
    }
}