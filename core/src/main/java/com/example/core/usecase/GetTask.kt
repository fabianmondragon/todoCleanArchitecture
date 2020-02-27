package com.example.core.usecase

import com.example.core.entity.Task
import com.example.core.repository.TaskRepository

class GetTask (private val taskRepository : TaskRepository) {
    suspend operator fun invoke( idTask:Int ) = taskRepository.getTask(idTask)
}