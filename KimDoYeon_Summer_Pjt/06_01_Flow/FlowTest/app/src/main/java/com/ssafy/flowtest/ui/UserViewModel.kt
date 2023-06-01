package com.ssafy.flowtest.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssafy.flowtest.data.User
import com.ssafy.flowtest.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

private const val TAG = "UserViewModel"
class UserViewModel :ViewModel(){
    private val userRepository = UserRepository.get()

    private val _userListState = MutableStateFlow<MutableList<User>>(mutableListOf())
    val userListState : StateFlow<MutableList<User>> = _userListState

    init {
        getList()
    }

    private fun getList(){
        viewModelScope.launch {
            userRepository.selectAll().collect{ userList->
                _userListState.update { userList }
            }
        }
    }

    fun insert(user : User){
        viewModelScope.launch {
            userRepository.insertUser(user)
        }

    }
}