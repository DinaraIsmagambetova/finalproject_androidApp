package com.example.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.example.todoapp.data.ToDoDataAccessObjects
import com.example.todoapp.data.models.ToDoData

class ToDoRepository(private val toDoDataAccessObjects: ToDoDataAccessObjects) {

    val getAllData: LiveData<List<ToDoData>> = toDoDataAccessObjects.getAllData()
    val sortByHighPriority: LiveData<List<ToDoData>> = toDoDataAccessObjects.sortByHighPriority()
    val sortByLowPriority: LiveData<List<ToDoData>> = toDoDataAccessObjects.sortByLowPriority()

    suspend fun insertData(toDoData: ToDoData) {
        toDoDataAccessObjects.insertData(toDoData)
    }

    suspend fun updateData(toDoData: ToDoData) {
        toDoDataAccessObjects.updateData(toDoData)
    }

    suspend fun deleteItem(toDoData: ToDoData) {
        toDoDataAccessObjects.deleteItem(toDoData)
    }

    suspend fun deleteAll(){
        toDoDataAccessObjects.deleteAll()
    }

    fun searchDatabase(searchQuery: String): LiveData<List<ToDoData>> {
        return toDoDataAccessObjects.searchDatabase(searchQuery)
    }
}