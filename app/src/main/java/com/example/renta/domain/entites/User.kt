package com.example.renta.domain.entites

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class User(
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("first_name") val first_name: String,
    @SerializedName("last_name") val last_name: String,
    @SerializedName("avatar") val avatar: String
) : Parcelable