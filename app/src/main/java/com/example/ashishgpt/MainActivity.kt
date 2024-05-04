package com.example.ashishgpt

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ashishgpt.database.ApiServiceFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data= arrayListOf<ChatClass>()

        val rv= findViewById<RecyclerView>(R.id.rv)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = Adapter(data)
        val sendButton: ImageButton = findViewById(R.id.imageButton)

        val chatModelFactory= ChatViewModelFactory( ChatRepository(ApiServiceFactory.createApiService()))

        // Initialize ViewModel
       val chatViewModel = ViewModelProvider(this, chatModelFactory)[ChatViewModel::class.java]

        chatViewModel.data.observe(this) { response ->

            data.add(ChatClass(response?.get(0)?.generated_text, false))
            rv.adapter?.notifyItemInserted(data.lastIndex)
            rv.scrollToPosition(data.lastIndex)
        }

        sendButton.setOnClickListener {
            val prompt = findViewById<EditText>(R.id.editTextText).text.toString()
            data.add(ChatClass(prompt,true))
            findViewById<EditText>(R.id.editTextText).text.clear()
            rv.adapter?.notifyItemInserted(data.lastIndex)
            chatViewModel.loadData("Bearer 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",GptRequest(prompt))

        }



    }
}
