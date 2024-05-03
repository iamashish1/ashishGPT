package com.example.ashishgpt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class ChatViewModel(private val repository: ChatRepository
): ViewModel() {


    private val _data = MutableLiveData<GptResponse?>()

    val data: MutableLiveData<GptResponse?> get() = _data

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun loadData(authorization:String, body:GptRequest) {
        viewModelScope.launch {
            _loading.value = true
            val chatResponse = repository.getGptResponse(authorization, body)
            _data.value = chatResponse
            _loading.value = false

        }
    }


    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{


        }

//        val Factory: (repository: ChatRepository) -> ViewModelProvider.Factory = { repository ->
//            object : ViewModelProvider.Factory {
//                @Suppress("UNCHECKED_CAST")
//                override fun <T : ViewModel> create(
//                    modelClass: Class<T>
//
//                ): T {
//                    return ChatViewModel(
//                        repository
//                    ) as T
//                }
//            }
//        }


    }
}

