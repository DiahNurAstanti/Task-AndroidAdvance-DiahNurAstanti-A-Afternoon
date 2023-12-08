package com.example.projectandroidadvanced

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class PostViewModel(val repository: PostRepository) : ViewModel() {
    val listComment = MutableLiveData<Response<Comment>>()
    val comment:LiveData<Response<Comment>>
        get() = listComment
    fun getComment(){
        CoroutineScope(Dispatchers.Main).launch { val Response= repository.getComment()
        listComment.value=Response}


    }


}