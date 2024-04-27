package com.example.ashishgpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data= arrayListOf<ChatClass>(ChatClass("THIS IS THE SENDER",true),ChatClass("THIS IS NOT THE SENDER",false))

        val rv= findViewById<RecyclerView>(R.id.rv)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = Adapter(data)
    }
}