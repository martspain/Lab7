package com.example.lab6.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [surveyInfo::class],version = 1, exportSchema = false)
abstract class SurveyDatabase: RoomDatabase() {
    abstract val surveyDatabaseDao: SurveyDatabaseDao
}