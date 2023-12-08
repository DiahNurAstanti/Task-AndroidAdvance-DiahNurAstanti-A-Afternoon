package com.example.projectandroidadvanced

import retrofit2.Response
import com.example.projectandroidadvanced.Comment
import retrofit2.http.GET

interface PostService {
    @GET("/posts/1/comments")
    suspend fun getComment():Response<Comment>
}