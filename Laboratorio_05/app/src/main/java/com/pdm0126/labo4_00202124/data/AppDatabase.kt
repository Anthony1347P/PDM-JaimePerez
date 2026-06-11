package com.pdm0126.labo4_00202124.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pdm0126.labo4_00202124.Model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}