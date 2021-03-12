package com.example.glance

import android.app.Application
import androidx.room.RoomDatabase

class TodoApplication : Application() {
    val database by lazy {TodoRoomDatabase.getDatabase(this)}
    val repositry by lazy {TodoRepository(database.todoDao())}
}