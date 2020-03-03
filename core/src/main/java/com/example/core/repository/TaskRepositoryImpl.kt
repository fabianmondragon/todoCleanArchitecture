package com.example.core.repository

import com.example.core.entity.Task

class TaskRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource

) : TaskRepository {
    lateinit var taskList: List<Task>

    override suspend fun saveTask(task: Task) {
        localDataSource.saveTask(task)
    }

    override suspend fun getAllTask(): List<Task> {
        taskList = localDataSource.getAllTask()
        if (taskList.isEmpty()) {
            taskList = remoteDataSource.getAllTask()
            localDataSource.saveTaskList(taskList)
        }
        return taskList
    }

    override suspend fun getTask(idTask: Int): Task {
        return localDataSource.getTask(idTask)
    }


}