package com.ssafy.firebasetestapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.ssafy.firebasetestapp.R
import com.ssafy.firebasetestapp.data.Test
import com.ssafy.firebasetestapp.databinding.ActivityListBinding
import com.ssafy.firebasetestapp.ui.adapter.ItemAdapter
import com.ssafy.firebasetestapp.ui.viewmodel.MainViewModel

private const val TAG = "ListActivity"
class ListActivity : AppCompatActivity() {
    lateinit var binding:ActivityListBinding
    lateinit var adapter : ItemAdapter
    lateinit var list : MutableList<Test>
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        list = mutableListOf<Test>()

        adapter = ItemAdapter(list, this@ListActivity)

        binding.itemRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.itemRecyclerView.adapter = adapter


        viewModel= MainViewModel()
        viewModel.items.observe(this){
            list.clear()
            it.map {
                Log.d(TAG, "onCreate: $it")
                list.add(it)
            }
            adapter.notifyDataSetChanged()
        }
        viewModel.setListener()


    }
}