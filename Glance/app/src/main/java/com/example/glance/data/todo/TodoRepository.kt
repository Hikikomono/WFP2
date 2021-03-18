package com.example.glance.data.todo

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {
    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allTodos : Flow<List<Todo>> = todoDao.getAllTodos()

    suspend fun getTodo(id: Int) : Todo{
        return todoDao.getTodo(id)
    }

    @WorkerThread
    suspend fun insert(todo: Todo){
        todoDao.insert(todo)
    }

    @WorkerThread
    suspend fun updateTodo(todo: Todo){
        todoDao.updateTodo(todo)
    }

    @WorkerThread
    suspend fun delteTodo(todo: Todo){
        todoDao.deleteTodo(todo)
    }


}