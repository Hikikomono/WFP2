package com.example.glance.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Todo::class), version = 1, exportSchema = false)
abstract class TodoRoomDatabase : RoomDatabase() {

    abstract fun todoDao() : TodoDao

    //START TODO DELETE - Just for Testing (populating DB)
    private class TodoDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.todoDao())
                }
            }
        }
        suspend fun populateDatabase(todoDao: TodoDao){
            var todo = Todo(50,"Inbox", "First Todo", "", false)
            todoDao.insert(todo)
            todo = Todo(51,"Inbox", "Second Todo", "", false)
            todoDao.insert(todo)
            todo = Todo(52,"Inbox", "Third Todo", "", false)
            todoDao.insert(todo)
            todo = Todo(53,"Inbox", "Fourth Todo", "", false)
            todoDao.insert(todo)
            todo = Todo(54,"Inbox", "Fifth Todo", "", false)
            todoDao.insert(todo)
            todo = Todo(55,"Inbox", "Sixth Todo", "", false)
            todoDao.insert(todo)
        }
    }
    //END

    companion object{
        @Volatile
        private var INSTANCE : TodoRoomDatabase? = null

        fun getDatabase (context: Context, scope: CoroutineScope) : TodoRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoRoomDatabase::class.java,
                    "todo_database"
                //TODO Remove .addCallback
                )
                    .addCallback(TodoDatabaseCallback(scope))
                    .build()
                INSTANCE = instance

                //return instance
                instance
            }
        }
    }
}