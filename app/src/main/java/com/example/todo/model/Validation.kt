package com.example.todo.model

class Validation {

    fun validateField(title: String, description: String): Boolean {
        if (title.isEmpty() || description.isEmpty()) return false
        return true
    }

}