package com.devcamp.usaintsdk

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitServiceChapel {

    @GET("posts/1")
    fun getUser(): Call<ChapelInfo>

    @GET("posts/{page}")
    fun getUserPage(@Path("page") page: String): Call<ChapelInfo>

}