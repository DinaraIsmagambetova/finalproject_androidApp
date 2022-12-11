package com.example.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.example.todoapp.data.ToDoDataAccessObjects
import com.example.todoapp.data.models.ToDoData

class ToDoRepository(private val toDoDataAccessObjects: ToDoDataAccessObjects) {

    val getAllData: LiveData<List<ToDoData>> = toDoDataAccessObjects.getAllData()

    suspend fun insertData(toDoData: ToDoData) {
        toDoDataAccessObjects.insertData(toDoData)
    }

    suspend fun updateData(toDoData: ToDoData) {
        toDoDataAccessObjects.updateData(toDoData)
    }
}