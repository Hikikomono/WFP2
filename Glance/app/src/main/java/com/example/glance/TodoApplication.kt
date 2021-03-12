package com.example.glance

import android.app.Application
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class TodoApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {TodoRoomDatabase.getDatabase(this, applicationScope)}
    val repository by lazy {TodoRepository(database.todoDao())}
}