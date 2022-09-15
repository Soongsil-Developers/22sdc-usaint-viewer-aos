package com.devcamp.usaintsdk

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Timetable {
    fun timetableRequest(id: String, pwd: String) {
        val retrofit = Retrofit.Builder().baseUrl("http://15.165.194.15:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build();
        val service = retrofit.create(RetrofitServiceTimetable::class.java);
        service.getUserPage("timetable/?id=$id&pwd=$pwd")?.enqueue(object : Callback<TimetableInfo> {
            override fun onResponse(call: Call<TimetableInfo>, response: Response<TimetableInfo>) {
                if (response.isSuccessful) {
                    // 정상적으로 통신이 성고된 경우
                    var result: TimetableInfo? = response.body()
                    Log.d("YMC", "onResponse 성공:: ${response.isSuccessful} " + result?.toString());
                } else {
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("YMC", "onResponse 실패 :: ${response.isSuccessful}")
                }
            }

            override fun onFailure(call: Call<TimetableInfo>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("YMC", "onFailure 에러: " + t.message.toString());
            }
        })
    }
}