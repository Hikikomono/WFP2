package com.example.glance.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {
    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allTodos : Flow<List<Todo>> = todoDao.getAllTodos()

    @WorkerThread
    suspend fun insert(todo: Todo){
        todoDao.insert(todo)
    }
}