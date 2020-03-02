package com.example.todo.framework.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "task")
data class TaskEntity (

    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name="name")
    val name: String
)

