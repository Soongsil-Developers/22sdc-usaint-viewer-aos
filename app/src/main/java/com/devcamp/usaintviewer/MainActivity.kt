package com.devcamp.usaintviewer

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.devcamp.usaintsdk.Login
import com.devcamp.usaintsdk.Test
import com.devcamp.usaintviewer.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val test = Test()
        test.showToast(this, "hello")

        val login = Login()

        val id = "20180285"
        val pwd = "~as369877"

        val loginUrl = URL("http://15.165.194.15:8080/login/?id=20180285&pwd=~as369877")
        val testURL = URL("https://jsonplaceholder.typicode.com/posts/1")

        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder().baseUrl("http://15.165.194.15:8080/").client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(RetrofitService::class.java);
        service.getUserPage("?id=$id&pwd=$pwd")?.enqueue(object : Callback<LoginInfo> {
            override fun onResponse(call: Call<LoginInfo>, response: Response<LoginInfo>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성고된 경우
                    var result: LoginInfo? = response.body()
                    Log.d("YMC", "onResponse 성공:: ${response.isSuccessful} " + result?.toString());
                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("YMC", "onResponse 실패 :: ${service}")
                }
            }

            override fun onFailure(call: Call<LoginInfo>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("YMC", "onFailure 에러: " + t.message.toString());
            }
        })


    }
}