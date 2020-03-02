package com.example.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.entity.Task
import com.example.todo.R
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.framework.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)
        val binding : ActivityMainBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)
        binding.todoViewModel = viewModel
        recyclerView.layoutManager = LinearLayoutManager (this)
        recyclerView.adapter = TaskAdapter (ArrayList<Task>(),this)
        binding.setLifecycleOwner(this)
    }


}
