package com.example.glance
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_table")
    fun getAllTodos(): Flow<List<Todo>>

    @Query("SELECT * FROM todo_table WHERE area = :area")
    fun getAllTodoFromArea(area : String) : Flow<List<Todo>>

    @Query("SELECT * FROM todo_table WHERE area = :area AND completed = 'false'")
    fun getAllTodoFromAreaNotCompleted(area: String) : Flow<List<Todo>>

    @Query("SELECT * FROM todo_table WHERE area = :area AND completed = 'true'")
    fun getAllTodoFromAreaCompleted(area: String) : Flow<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(todo: Todo)

    @Update
    fun updateTodo(todo: Todo)

    @Query ("UPDATE todo_table SET completed = 'true' WHERE id = :id")
    fun updateSetTodoCompleted(id: Int)

    @Query ("UPDATE todo_table SET area = :newArea WHERE id = :id")
    fun updateTodoArea(id: Int, newArea: String)

    @Delete
    fun deleteTodo(todo: Todo)
}