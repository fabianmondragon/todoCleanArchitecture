package com.example.todo.framework.di

import com.example.todo.model.Validation
import dagger.Module
import dagger.Provides

@Module
class TodoModule {

    @Provides
    fun provideValidation () = Validation()
}