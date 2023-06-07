package com.ssafy.likedislike.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.likedislike.data.CardItem
import com.ssafy.likedislike.databinding.ActivityMainBinding
import com.ssafy.likedislike.ui.result.ResultActivity
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.StackFrom

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var cardAdapter : CardStackAdapter
    private lateinit var list : MutableList<CardItem>
    private lateinit var manager: CardStackLayoutManager
    private lateinit var likedList : MutableList<CardItem>
    private lateinit var disLikedList : MutableList<CardItem>
    private lateinit var appeardItem : CardItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        likedList= mutableListOf()
        disLikedList= mutableListOf()
        appeardItem= CardItem("", "")

        setList()
        setRecyclerView()

    }

    fun like(){
        Toast.makeText(this, "liked!", Toast.LENGTH_SHORT).show()
        likedList.add(appeardItem)
        if(list[list.size-1]===appeardItem){//=== 으로 비교하면 같은 객체인지 비교, ==은 값이 같은지 비교
            end()
        }
    }

    fun disLike(){
        Toast.makeText(this, "disLiked!", Toast.LENGTH_SHORT).show()
        disLikedList.add(appeardItem)
        if(list[list.size-1]===appeardItem){
            end()
        }
    }

    fun end(){
        Log.d(TAG, "onCardDisappeared: -------------------liked-----------------------")
        likedList.forEachIndexed { index, cardItem ->
            Log.d(TAG, "onCardDisappeared: $cardItem")
        }
        Log.d(TAG, "onCardDisappeared: -------------------disLiked-----------------------")
        disLikedList.forEachIndexed { index, cardItem ->
            Log.d(TAG, "onCardDisappeared: $cardItem")
        }
        val intent = Intent(this, ResultActivity::class.java)
        var likedArrayList : ArrayList<CardItem> = ArrayList<CardItem>()
        var disLikedArrayList : ArrayList<CardItem> = ArrayList<CardItem>()

        likedArrayList.addAll(likedList)
        disLikedArrayList.addAll(disLikedList)
        intent.putExtra("liked", likedArrayList)
        intent.putExtra("disLiked", disLikedArrayList)
        startActivity(intent)
        finish()
    }

    fun setRecyclerView(){
        cardAdapter = CardStackAdapter(list)
        manager = CardStackLayoutManager(this, object : CardStackListener {
            override fun onCardDragging(direction: Direction?, ratio: Float) {
            }

            override fun onCardSwiped(direction: Direction?) {
                when (direction) {
                    Direction.Right -> {
                        like()
                    }
                    Direction.Left -> {
                        disLike()
                    }
                    else -> Unit
                }
            }

            override fun onCardRewound() {
            }

            override fun onCardCanceled() {
            }

            override fun onCardAppeared(view: View?, position: Int) {
                Log.d(TAG, "onCardAppeared: ${list[position]}")
                appeardItem = list[position]//= 으로 값을 넣으면 동일한 주소값을 가지게된다, 동일한 heap에 있는 객체를 가리키게됨
            }

            override fun onCardDisappeared(view: View?, position: Int) {

            }

        })

        manager!!.setStackFrom(StackFrom.Top)
        manager.setCanScrollVertical(false)
        binding.cardStackView.apply {
            layoutManager = manager
            adapter = cardAdapter
        }
        Log.d(TAG, "setRecyclerView: size ${list.size}")
    }

    fun setList(){
        list = mutableListOf()
        list.add(CardItem("1", "민트초코"))
        list.add(CardItem("2", "탕수육 부먹"))
        list.add(CardItem("3", "아침햇살"))
        list.add(CardItem("4", "솔의눈"))
        list.add(CardItem("5", "닥터페퍼"))
        list.add(CardItem("6", "데자와"))
        list.add(CardItem("7", "실론티"))
    }

}