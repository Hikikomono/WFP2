package com.example.glance
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "todo_table")
class Todo(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
        @ColumnInfo(name = "area", defaultValue = "inbox") val area : String,
        @ColumnInfo(name = "title") val title : String,
        @ColumnInfo(name = "description") val description : String?,
        /* TODO Dateconverter implementieren -> dann Kommentierung von Properties entfernen
        @ColumnInfo(name = "created_date") val created_date : Date,
        @ColumnInfo(name = "deadline_date") val deadline_date : Date?,
        @ColumnInfo(name = "do_date") val do_date : Date?,
        @ColumnInfo(name = "completed_date") val completed_date : Date?,
        */
        @ColumnInfo(name = "completed", defaultValue = "false") val completed : Boolean
)