package com.example.core.usecase

import com.example.core.entity.Task
import com.example.core.repository.TaskRepository

class AddTask (private val taskRepository: TaskRepository)
{
    suspend operator fun invoke(task: Task) = taskRepository.saveTask(task)
}