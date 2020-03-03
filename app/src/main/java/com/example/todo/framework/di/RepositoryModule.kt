package com.example.todo.framework.di

import android.app.Application
import com.example.core.repository.LocalDataSource
import com.example.core.repository.TaskRepositoryImpl
import com.example.todo.framework.RetrofitDataSource
import com.example.todo.framework.RoomDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = TaskRepositoryImpl(RoomDataSource(app), RetrofitDataSource(app))


}