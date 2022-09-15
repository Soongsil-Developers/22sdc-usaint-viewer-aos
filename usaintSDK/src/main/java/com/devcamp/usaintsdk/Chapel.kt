package com.devcamp.usaintsdk

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Chapel {
    fun chapelRequest(id: String, pwd: String) {
        val retrofit = Retrofit.Builder().baseUrl("http://15.165.194.15:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(RetrofitServiceChapel::class.java)
        service.getUserPage("chapel/?id=$id&pwd=$pwd")?.enqueue(object : Callback<ChapelInfo> {
            override fun onResponse(call: Call<ChapelInfo>, response: Response<ChapelInfo>) {
                if (response.isSuccessful) {
                    // 정상적으로 통신이 성고된 경우
                    var result: ChapelInfo? = response.body()
                    Log.d("YMC", "onResponse 성공:: ${response.isSuccessful} " + result?.toString());
                } else {
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("YMC", "onResponse 실패 :: ${response.isSuccessful}")
                }
            }

            override fun onFailure(call: Call<ChapelInfo>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("YMC", "onFailure 에러: " + t.message.toString());
            }
        })
    }
}