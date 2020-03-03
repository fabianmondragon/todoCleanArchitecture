package com.example.core.usecase

import com.example.core.repository.TaskRepository

class GetAllTask(private val taskRepository: TaskRepository) {

    suspend operator fun invoke() = taskRepository.getAllTask()


}