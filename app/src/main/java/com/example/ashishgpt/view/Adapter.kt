package com.example.ashishgpt.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ashishgpt.databinding.GptItemBinding
import com.example.ashishgpt.databinding.UserItemBinding
import com.example.ashishgpt.model.ChatClass

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

    inner class UserViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    inner class GPTViewHolder(val binding: GptItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
           val binding= UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            UserViewHolder(binding)
        } else {
            val binding = GptItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            GPTViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentRoom = rooms[position]
        println(currentRoom.question)
        println(currentRoom.isSender)
        if (holder is UserViewHolder) {
            holder.binding.texts = currentRoom

        }else if (holder is GPTViewHolder) {
            holder.binding.texts = currentRoom
        }
    }

}
