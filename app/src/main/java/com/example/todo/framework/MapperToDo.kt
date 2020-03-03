package com.example.todo.framework

import com.example.core.entity.Task
import com.example.todo.framework.data.TaskEntity
import com.google.gson.Gson
import org.modelmapper.ModelMapper

class MapperToDo {
    var gson: Gson

    init {
        gson = Gson()
    }

    private fun toStringModelMapper(value: Any): String {
        return gson.toJson(value)
    }

    fun fromDBtoDomain(entityTask: Any): Task {
        return gson.fromJson(toStringModelMapper(entityTask), Task::class.java)
    }

    fun fromDomaintoEntity(task: Any): TaskEntity {
        return gson.fromJson(toStringModelMapper(task), TaskEntity::class.java)
    }

    fun fromListDBtoListDomain(entityTaskList: List<TaskEntity>): List<Task> {
        val gson = Gson()
        val jsonOutput = "Your JSON String"
        return gson.fromJson(toStringModelMapper(entityTaskList), Array<Task>::class.java).toList()
    }

    fun fromListDomaintoListDB(taskList: List<Task>): List<TaskEntity> {
        val modelMapper = ModelMapper()
        val listTaskEntity = ArrayList<TaskEntity>()
        return modelMapper.map(toStringModelMapper(taskList), listTaskEntity.javaClass)
    }

}