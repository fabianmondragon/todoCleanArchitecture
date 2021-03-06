package com.example.todo.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val nameTask = intent.extras?.getString("name")
        val description = intent.extras?.getString("description")

        val textTitle = findViewById<TextView>(R.id.textViewTitle)
        val textDescription = findViewById<TextView>(R.id.textViewDescription)

        textTitle.text = nameTask
        textDescription.text = description
    }
}
