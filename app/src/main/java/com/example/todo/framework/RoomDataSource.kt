package com.example.todo.framework

import android.content.Context
import com.example.core.entity.Task
import com.example.core.repository.LocalDataSource
import com.example.todo.framework.data.DatabaseService

class RoomDataSource (context: Context) : LocalDataSource {
    val taskDao = DatabaseService.getInstance(context).taskDao()
    lateinit var mapperToDo: MapperToDo

    override suspend fun saveTask(task: Task) {
        mapperToDo = MapperToDo()
        taskDao.insertTask(mapperToDo.fromDomaintoEntity(task))
    }

    override suspend fun saveTaskList(taskList: List<Task>) {

    }

    override suspend fun getAllTask(): List<Task> {
        mapperToDo = MapperToDo()
        return mapperToDo.fromListDBtoListDomain(taskDao.getAll())
    }
    override suspend fun getTask(): Task {
        mapperToDo = MapperToDo()
        return mapperToDo.fromDBtoDomain(taskDao.getTask(1))
    }
}