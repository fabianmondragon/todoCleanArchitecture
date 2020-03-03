package com.example.core.repository

import com.example.core.entity.Task

interface RemoteDataSource {

    suspend fun getAllTask(): List<Task>

    suspend fun getTask(): Task

}