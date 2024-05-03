package com.example.ashishgpt

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ashishgpt.database.ChatDatabase


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data= arrayListOf<ChatClass>()

        val rv= findViewById<RecyclerView>(R.id.rv)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = Adapter(data)
        val sendButton: ImageButton = findViewById(R.id.imageButton)

        val chatModelFactory= ChatViewModelFactory( ChatRepository(ChatDatabase.getChatAPI()))

        // Initialize ViewModel
       val chatViewModel = ViewModelProvider(this, chatModelFactory)[ChatViewModel::class.java]

        sendButton.setOnClickListener {
            val prompt = findViewById<EditText>(R.id.editTextText).text.toString()
            chatViewModel.loadData("Bearer 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",GptRequest(prompt))


//
//            data.add(ChatClass(prompt,true))
//            rv.adapter?.notifyItemInserted(data.lastIndex)
//            findViewById<EditText>(R.id.editTextText).text.clear()
//            lifecycleScope.launch {
//                try {
//                    val retrofit = Retrofit.Builder()
//                        .baseUrl("https://api-inference.huggingface.co/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build()
//                    val service: ApiService = retrofit.create(ApiService::class.java)
//                    val response = service.getGptResponse(
//                        authorization = "Bearer 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",
//                        body = GptRequest(prompt)
//                    )
//                    if (response.isSuccessful) {
//
//                        val gptResponse = response.body()
//                        println(gptResponse)
//
//                        data.add(ChatClass(gptResponse?.get(0)?.generated_text.toString(),false))
//                        rv.adapter?.notifyItemInserted(data.lastIndex)
//                        rv.scrollToPosition(data.lastIndex)
//
//                    } else {
//                        println(response.message())
//                        // CHECK OTHER ERROR CODES AND HANDLE
//                    }
//                } catch (e: Exception) {
//                    //HANDLE OTHER ERRORS SUCH AS NETWORK ERROR
//                    e.printStackTrace()
//                }
//            }
        }



    }
}
