package com.example.renta.datalayer.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "CachingUsers")
data class CachingUser(
    @PrimaryKey
    @SerializedName("id") val id: Int,

    @SerializedName("email") val email: String,
    @SerializedName("first_name") val first_name: String,
    @SerializedName("last_name") val last_name: String,
    @SerializedName("avatar") val avatar: String,
)