package com.devcamp.usaintviewer

import com.google.gson.annotations.SerializedName

data class LoginInfo(
    @SerializedName("status")
    val status: String,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: String
)