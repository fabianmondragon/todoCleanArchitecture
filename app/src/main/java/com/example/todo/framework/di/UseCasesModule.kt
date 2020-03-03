package com.example.todo.framework.di

import com.example.core.repository.TaskRepository
import com.example.core.repository.TaskRepositoryImpl
import com.example.core.usecase.AddTask
import com.example.core.usecase.GetAllTask
import com.example.todo.framework.UseCases

import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: TaskRepositoryImpl) = UseCases (
        AddTask(repository),
        GetAllTask(repository)
    )
}