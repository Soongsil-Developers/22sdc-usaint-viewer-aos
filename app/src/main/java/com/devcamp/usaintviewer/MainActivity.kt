package com.devcamp.usaintviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devcamp.usaintsdk.Test

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test = Test()
        test.showToast(this,"hello")
    }
}