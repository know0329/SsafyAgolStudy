package com.ssafy.firebasetestapp.ui.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.internal.Storage
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.ssafy.firebasetestapp.data.Test

class MainViewModel {
    private lateinit var mDatabase : DatabaseReference
    private var storage : StorageReference
    private val _items : MutableLiveData<MutableList<Test>> = MutableLiveData<MutableList<Test>>()
    val items : LiveData<MutableList<Test>>
        get() = _items

    init {
        mDatabase = FirebaseDatabase.getInstance().getReference()
        storage = Firebase.storage.getReference()
    }

    fun insert(item: Test, uri : Uri){
        val fileName="article/photo/${System.currentTimeMillis()}.png"
        val fileRef = storage.child(fileName)
        storage.child(fileName)
            .putFile(uri)
            .addOnCompleteListener {
                fileRef.downloadUrl.addOnSuccessListener {
                    item.imageUrl=it.toString()
                    mDatabase.push().setValue(item)
                }

            }

    }

    fun setListener(){
        mDatabase.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var newList = mutableListOf<Test>()
                if(snapshot.exists()){
                    for(item in snapshot.children){
                        val testItem = Test(item.key!!, item.child("imageUrl").value.toString(), item.child("content").value.toString())
                        newList.add(testItem)
                    }
                    _items.postValue(newList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}