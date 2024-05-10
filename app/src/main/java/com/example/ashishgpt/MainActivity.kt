package com.example.ashishgpt

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ashishgpt.databinding.ActivityMainBinding
import com.example.ashishgpt.model.ChatClass
import com.example.ashishgpt.model.GptRequest
import com.example.ashishgpt.view.Adapter
import com.example.ashishgpt.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var editTextValue = ObservableField<String>("")

    private lateinit var binding: ActivityMainBinding
    // viewModels() delegate used to get
    // by view models will automatically construct the viewmodels using Hilt
    private lateinit var chatViewModel: ChatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val data= arrayListOf<ChatClass>()

        val rv= binding.rv

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = Adapter(data)
        val sendButton: ImageButton = binding.imageButton

//        val chatModelFactory= ChatViewModelFactory( ChatRepository(ApiServiceFactory.createApiService()))
        // Initialize ViewModel
//       val chatViewModel = ViewModelProvider(this, chatModelFactory)[ChatViewModel::class.java]
        chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]

        chatViewModel.data.observe(this) { response ->

            data.add(ChatClass(response?.get(0)?.generated_text, false))
            rv.adapter?.notifyItemInserted(data.lastIndex)
            rv.scrollToPosition(data.lastIndex)
        }

        sendButton.setOnClickListener {

            if(editTextValue.get()!!.isEmpty()){
                println("WHY IS ITNULL")
                return@setOnClickListener
            }

//            val prompt = binding.editTextText.text.toString()
            data.add(ChatClass( editTextValue.get()?:"",true))

            rv.adapter?.notifyItemInserted(data.lastIndex)
            chatViewModel.loadData("Bearer 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",
                GptRequest(editTextValue.get()?:"")
            )
            editTextValue.set("")

        }



    }
}
