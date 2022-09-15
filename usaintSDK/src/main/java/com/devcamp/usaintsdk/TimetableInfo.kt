package com.devcamp.usaintsdk

import com.google.gson.annotations.SerializedName

data class TimetableInfo(
    @SerializedName("time")
    val status: String,

    @SerializedName("seatNumber")
    val message: String,

    @SerializedName("absences")
    val data: List<TimetableDto>
)
