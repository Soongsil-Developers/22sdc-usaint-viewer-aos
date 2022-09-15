package com.devcamp.usaintsdk

import com.google.gson.annotations.SerializedName

data class ChapelInfo(
    @SerializedName("time")
    val time: String,

    @SerializedName("seatNumber")
    val seatNumber: String,

    @SerializedName("absences")
    val absences: String
)
