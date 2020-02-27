package com.example.todo.framework.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class TaskDao {

    @Query("SELECT * FROM task")
    abstract fun getAll(): List<TaskEntity>

    @Insert
    abstract fun insertTask(task: TaskEntity)

    @Query("SELECT * FROM task WHERE task.id = :id")
    abstract fun getTask(id: Int): TaskEntity

    @Query("DELETE FROM task WHERE task.id = :id")
    abstract fun delete(id: Int)

}