package com.example.glance.data.todo

import androidx.lifecycle.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {
    // Using LiveData and caching what allTodos returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allTodos : LiveData<List<Todo>> = repository.allTodos.asLiveData()
    var allTodosFromArea: LiveData<List<Todo>>? = null

    fun getAllTodoFromArea(area: String){
        viewModelScope.launch {
            allTodosFromArea = repository.getAllTodoFromArea(area).asLiveData()
        }
    }


    //get a specifict TodoObject
    suspend fun getTodoFromDatabase(id: Int) : Todo{
        return repository.getTodo(id)
    }

    //get the amount of Items in a specific Area
    suspend fun getTodoAreaCount(area: String): Int{
        return repository.getTodoAreaCount(area)
    }

    //Launching a new coroutine to insert the data in a non-blocking way
    fun insert(todo: Todo) = viewModelScope.launch{
        repository.insert(todo)
    }

    suspend fun updateTodo(todo: Todo){
        repository.updateTodo(todo)
    }

    suspend fun deleteTodo(todo: Todo){
        repository.delteTodo(todo)
    }


}


// By using viewModels and ViewModelProvider.Factory then the framework will take care
// of the lifecycle of the ViewModel.

class TodoViewModelFactory(private val repository: TodoRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            return TodoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}