package com.example.todo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer


import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.entity.Task
import com.example.todo.R
import com.example.todo.databinding.ActivityMainBinding

import com.example.todo.framework.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var viewModel: TodoViewModel
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.todoViewModel = viewModel
        recyclerView.layoutManager = LinearLayoutManager (this)
        taskAdapter = TaskAdapter (ArrayList<Task>(),this, this)
        recyclerView.adapter = taskAdapter
        binding.setLifecycleOwner(this)
        setObservers()
    }

    private fun setObservers (){
        viewModel.taskList.observe(this, Observer {
            if (it != null){
                val taskList = ArrayList<Task>(it)
                taskAdapter.updateInformation(taskList)
            }
        })
    }

    override fun onItemClicked(task: Task) {
        var intent = Intent()
        intent.putExtra("name", task.name)
        intent.putExtra("description", task.description)
        intent.setClass(this, DetailActivity::class.java)
        startActivity(intent)
    }


}
