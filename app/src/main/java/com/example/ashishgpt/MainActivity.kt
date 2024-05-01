package com.example.ashishgpt

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data= arrayListOf<ChatClass>()

        val rv= findViewById<RecyclerView>(R.id.rv)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = Adapter(data)
        val sendButton: ImageButton = findViewById(R.id.imageButton)

        sendButton.setOnClickListener {
            val prompt = findViewById<EditText>(R.id.editTextText).text.toString()
            data.add(ChatClass(prompt,true))
            rv.adapter?.notifyItemInserted(data.lastIndex)
            findViewById<EditText>(R.id.editTextText).text.clear()
            lifecycleScope.launch {
                try {
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://api-inference.huggingface.co/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    val service: ApiService = retrofit.create(ApiService::class.java)
                    val response = service.getGptResponse(
                        authorization = "Bearer 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",
                        body = GptRequest(prompt)
                    )
                    if (response.isSuccessful) {

                        val gptResponse = response.body()
                        println(gptResponse)

                        data.add(ChatClass(gptResponse?.get(0)?.generated_text.toString(),false))
                        rv.adapter?.notifyItemInserted(data.lastIndex)

                    } else {
                        println(response.message())
                        // CHECK OTHER ERROR CODES AND HANDLE
                    }
                } catch (e: Exception) {
                    //HANDLE OTHER ERRORS SUCH AS NETWORK ERROR
                    e.printStackTrace()
                }
            }
        }



    }
}
