package com.example.todo.framework

import android.content.Context
import com.example.core.entity.Task
import com.example.core.repository.RemoteDataSource

class RetrofitDataSource (context: Context): RemoteDataSource {
    override suspend fun getAllTask(): List<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getTask(): Task {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}