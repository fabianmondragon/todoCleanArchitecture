package com.example.todo.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.core.entity.Task
import com.example.core.repository.TaskRepository
import com.example.core.repository.TaskRepositoryImpl
import com.example.core.usecase.AddTask
import com.example.core.usecase.GetAllTask
import com.example.todo.framework.UseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel ( application: Application) : AndroidViewModel (application){


    val taskList = MutableLiveData<List<Task>>()
    val currentTask = MutableLiveData<Task>()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val taskRepositoryImpl = TaskRepositoryImpl(RoomDataSource(application), RetrofitDataSource(application) )

    val useCases: UseCases = UseCases(
        AddTask(taskRepositoryImpl),
        GetAllTask(taskRepositoryImpl)
    )

    fun registerTask (){
        coroutineScope.launch {
            val task = Task("tarea1", "description")
            useCases.addTask.invoke(task)
            val listOfTask = useCases.getAllTask.invoke()
            taskList.postValue(listOfTask)
        }
    }

}