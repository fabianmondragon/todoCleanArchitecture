package com.example.todo.framework

import android.content.Context
import com.example.core.entity.Task
import com.example.core.repository.RemoteDataSource

class RetrofitDataSource(context: Context) : RemoteDataSource {
    override suspend fun getAllTask(): List<Task> {
        //To change body of created functions use File | Settings | File Templates.
        var list = ArrayList<Task>()
        return list
    }

    override suspend fun getTask(): Task {
        //To change body of created functions use File | Settings | File Templates.
        val task = Task("", "")
        return task
    }
}