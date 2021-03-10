package com.example.glance

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {
    // Using LiveData and caching what allTodos returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allTodos : LiveData<List<Todo>> = repository.allTodos.asLiveData()


    //Launching a new coroutine to insert the data in a non-blocking way
    fun insert(todo: Todo) = viewModelScope.launch{
        repository.insert(todo)
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