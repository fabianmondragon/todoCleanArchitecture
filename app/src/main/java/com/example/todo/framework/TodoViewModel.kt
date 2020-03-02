package com.example.todo.framework

import android.app.Application
import android.widget.EditText
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.entity.Task
import com.example.core.repository.TaskRepository
import com.example.core.repository.TaskRepositoryImpl
import com.example.core.usecase.AddTask
import com.example.todo.framework.UseCases
import com.example.todo.ui.Validation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel ( application: Application) : AndroidViewModel (application){

    val editTextTitle = MutableLiveData<String>()
    val editTextDescription = MutableLiveData<String>()
    private val validation = Validation()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val taskRepositoryImpl = TaskRepositoryImpl(RoomDataSource(application), RetrofitDataSource(application) )

    val useCases: UseCases = UseCases(
        AddTask(taskRepositoryImpl)
    )

    fun registerTask (){
        coroutineScope.launch {
            if (validation.validateField(editTextTitle.value.toString(), editTextDescription.value.toString()))
            {
                val task = Task(editTextTitle.value.toString(), editTextDescription.value.toString())
                useCases.addTask.invoke(task)
            }
        }
    }
}