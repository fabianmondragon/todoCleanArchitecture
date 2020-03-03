package com.example.todo.framework.di

import com.example.todo.framework.TodoViewModel
import com.example.todo.model.Validation
import dagger.Component

@Component(modules = [ApplicationModule::class,  UseCasesModule::class, RepositoryModule::class, TodoModule::class] )
interface ToDoComponent {

    fun inject (todoViewModel: TodoViewModel)
}