package com.example.renta.ui.home.RV

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.renta.databinding.UserItemBinding
import com.example.renta.domain.entites.User

class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: UserItemBinding = UserItemBinding.bind(itemView)

    fun bind(user: User) {
        binding.title.text = user.first_name
    }
}