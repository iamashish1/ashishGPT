package com.example.ashishgpt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.ashishgpt.repository.ChatRepository

class ChatViewModelFactory(private val chatRepository: ChatRepository)  : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return ChatViewModel(chatRepository) as T
    }
}


