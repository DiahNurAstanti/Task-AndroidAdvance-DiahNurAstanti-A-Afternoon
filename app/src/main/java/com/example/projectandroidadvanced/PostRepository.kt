package com.example.projectandroidadvanced

import retrofit2.Response

class PostRepository (){
    suspend fun getComment(): Response<Comment> = PostClient.service.getComment()

}