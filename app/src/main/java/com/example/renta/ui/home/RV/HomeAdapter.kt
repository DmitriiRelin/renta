package com.example.renta.ui.home.RV

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.renta.R
import com.example.renta.domain.entites.User

//class HomeAdapter(val onItemClickListener: (User) -> Unit) : RecyclerView.Adapter<HomeHolder>() {
//
//    var usersList = listOf<User>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
//        return HomeHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
//        val cinema = cinemaList[position]
//        holder.itemView.setOnClickListener {
//            onItemClickListener.invoke(cinema)
//        }
//        holder.bind(cinema)
//    }
//
//    override fun getItemCount(): Int = cinemaList.size
//
//}