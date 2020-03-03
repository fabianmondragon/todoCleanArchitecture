package com.example.todo.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.core.entity.Task
import com.example.todo.framework.di.ApplicationModule
import com.example.todo.framework.di.DaggerToDoComponent
import com.example.todo.model.Validation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var useCases: UseCases

    @Inject
    lateinit var validation: Validation

    val editTextTitle = MutableLiveData<String>()
    val editTextDescription = MutableLiveData<String>()
    val taskList = MutableLiveData<List<Task>>()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        DaggerToDoComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

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