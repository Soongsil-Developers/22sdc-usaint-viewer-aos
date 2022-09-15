package com.devcamp.usaintsdk

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitServiceLogin {

    @GET("posts/1")
    fun getUser(): Call<LoginInfo>

    @GET("posts/{page}")
    fun getUserPage(@Path("page") page: String): Call<LoginInfo>
}