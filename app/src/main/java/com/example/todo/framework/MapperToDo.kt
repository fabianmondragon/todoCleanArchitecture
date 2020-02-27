package com.example.todo.framework

import com.example.core.entity.Task
import com.example.todo.framework.data.TaskEntity
import org.modelmapper.ModelMapper

class MapperToDo {

    fun fromDBtoDomain (entityTask: TaskEntity): Task{
        val modelMapper = ModelMapper()
        return modelMapper.map(entityTask, Task::class.java)
    }

    fun fromListDBtoListDomain (entityTaskList: List<TaskEntity>): List<Task>{
        val modelMapper = ModelMapper()
        val listTaskModel = ArrayList<Task>()
        return modelMapper.map(entityTaskList, listTaskModel.javaClass)
    }

    fun fromDomaintoEntity (task: Task): TaskEntity{
        val modelMapper = ModelMapper()
        return modelMapper.map(task, TaskEntity::class.java)
    }


}