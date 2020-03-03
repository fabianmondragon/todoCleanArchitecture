package com.example.todo.framework

import com.example.core.usecase.AddTask
import com.example.core.usecase.GetAllTask

data class UseCases (
    val addTask: AddTask,
    val getAllTask: GetAllTask
)

