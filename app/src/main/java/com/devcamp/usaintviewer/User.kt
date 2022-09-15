package com.devcamp.usaintviewer

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("userId")
    val userId: Int,

    @SerializedName("id")
    val id: String,

    @SerializedName("body")
    val body: String
)
