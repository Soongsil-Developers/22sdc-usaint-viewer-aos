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
        val testButton : Button = binding.testButton
        testButton.setOnClickListener{
            Log.d("MainActivity", "hello")
            val loginUrl = URL("http://15.165.194.15:8080/login/?id=$id&pwd=$pwd")
            val myConnection: HttpURLConnection = loginUrl.openConnection() as HttpURLConnection
            Log.d("MainActivity","${loginUrl.toString()}")
            val resmsg  = myConnection.responseMessage
            Log.d("Resmsg",resmsg)
        }




    }
}