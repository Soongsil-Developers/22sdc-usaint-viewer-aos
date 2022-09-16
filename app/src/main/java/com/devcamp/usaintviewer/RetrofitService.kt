package com.devcamp.usaintviewer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("login")
    fun getUser(): Call<LoginInfo>

    @GET("login/{page}")
    fun getUserPage(@Path("page") page: String): Call<LoginInfo>
}