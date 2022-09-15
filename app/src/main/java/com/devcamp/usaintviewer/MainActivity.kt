package com.devcamp.usaintviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.devcamp.usaintsdk.Login
import com.devcamp.usaintsdk.Test
import com.devcamp.usaintviewer.databinding.ActivityMainBinding
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


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

        val loginUrl = URL("http://15.165.194.15:8080/login/?id=$id&pwd=$pwd")
        val testURL = URL("https://jsonplaceholder.typicode.com/posts/1")

        val retrofit = Retrofit.Builder().baseUrl("http://15.165.194.15:8080/")
            .addConverterFactory(GsonConverterFactory.create()).build();
        val service = retrofit.create(RetrofitService::class.java);
        service.getUserPage("login/?id=$id&pwd=$pwd")?.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성고된 경우
                    var result: User? = response.body()
                    Log.d("YMC", "onResponse 성공:: ${response.isSuccessful} " + result?.toString());
                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("YMC", "onResponse 실패 :: ${response.isSuccessful}")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("YMC", "onFailure 에러: " + t.message.toString());
            }
        })


    }
}