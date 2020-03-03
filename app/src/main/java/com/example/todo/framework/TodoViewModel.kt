package com.example.todo.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.core.entity.Task
import com.example.core.repository.TaskRepositoryImpl
import com.example.core.usecase.AddTask
import com.example.core.usecase.GetAllTask
import com.example.todo.model.Validation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    val editTextTitle = MutableLiveData<String>()
    val editTextDescription = MutableLiveData<String>()
    val taskList = MutableLiveData<List<Task>>()
    private val validation = Validation()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val taskRepositoryImpl =
        TaskRepositoryImpl(RoomDataSource(application), RetrofitDataSource(application))

    val useCases: UseCases = UseCases(
        AddTask(taskRepositoryImpl),
        GetAllTask(taskRepositoryImpl)
    )

    fun registerTask() {
        coroutineScope.launch {
            if (validation.validateField(
                    editTextTitle.value.toString(),
                    editTextDescription.value.toString()
                )
            ) {
                val task =
                    Task(editTextTitle.value.toString(), editTextDescription.value.toString())
                useCases.addTask.invoke(task)
                val listOfTask = useCases.getAllTask.invoke()
                taskList.postValue(listOfTask)
            }
        }
    }

    fun getAllTask() {
        coroutineScope.launch {
            val listOfTask = useCases.getAllTask.invoke()
            taskList.postValue(listOfTask)

        }

    }
}