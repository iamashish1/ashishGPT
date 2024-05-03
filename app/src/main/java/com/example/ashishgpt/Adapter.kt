package com.example.ashishgpt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private var rooms: MutableList<ChatClass>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (rooms[position].isSender) {
            0
        } else {
            1
        }
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.userDesc)
        // Other views specific to UserViewHolder
    }

    inner class GPTViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.gptTitle)
        // Other views specific to GPTViewHolder
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
            UserViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.gpt_item, parent, false)
            GPTViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentRoom = rooms[position]

        if (holder is UserViewHolder) {
            holder.tvTitle.text = currentRoom.question
            // Set other views specific to UserViewHolder
        } else if (holder is GPTViewHolder) {
            holder.tvTitle.text = currentRoom.question
            // Set other views specific to GPTViewHolder
        }
    }


}
