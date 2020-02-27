package com.example.core.repository

import com.example.core.entity.Task

interface LocalDataSource {
    suspend fun getAllTask (): List<Task>

    suspend fun getTask(idTask: Int): Task

    suspend fun saveTaskList(taskList : List<Task>)

    suspend fun saveTask(task : Task)


}