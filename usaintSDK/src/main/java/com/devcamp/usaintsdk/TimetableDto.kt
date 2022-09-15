package com.devcamp.usaintsdk

import com.google.gson.annotations.SerializedName

data class TimetableDto(
    @SerializedName("category")
    val category: String,

    @SerializedName("multipleMajorCategory")
    val multipleMajorCategory: String,

    @SerializedName("subjectArea")
    val subjectArea: String,

    @SerializedName("subjectID")
    val subjectID: String,

    @SerializedName("subjectName")
    val subjectName: String,

    @SerializedName("separatedClass")
    val separatedClass: String,

    @SerializedName("professor")
    val professor: String,

    @SerializedName("credit")
    val credit: String,

    @SerializedName("dateTimeClass")
    val dateTimeClass: String,

    @SerializedName("course")
    val course: String,

    @SerializedName("signedDate")
    val signedDate: String,

    @SerializedName("note")
    val note: String,

    @SerializedName("abeek")
    val abeek: String,


)
