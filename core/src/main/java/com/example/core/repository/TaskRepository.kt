package com.example.core.repository

import com.example.core.entity.Task

interface TaskRepository {

    suspend fun getAllTask (): List<Task>

    suspend fun getTask(): Task

    suspend fun saveTask (task: Task)

}