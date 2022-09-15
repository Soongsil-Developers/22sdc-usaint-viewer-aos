package com.devcamp.usaintviewer

import com.google.gson.annotations.SerializedName

data class LoginReturn(
    @SerializedName("userId")
    val status: String,

    @SerializedName("id")
    val message: String,

    @SerializedName("body")
    val data: String
)