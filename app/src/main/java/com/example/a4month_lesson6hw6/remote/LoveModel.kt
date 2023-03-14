package com.example.a4month_lesson6hw6.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//    {
//        "fname": "Tilek",
//        "sname": "Alice",
//        "percentage": "75",
//        "result": "All the best!"
//    }

@Entity(tableName = "love_model")
data class LoveModel (
    @PrimaryKey(autoGenerate = true)
    var id:Int?,
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String,
):java.io.Serializable