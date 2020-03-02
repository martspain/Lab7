package com.example.lab6.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SurveyDatabaseDao {

    @Insert
    fun insert(question: surveyInfo)

    @Update
    fun update(answer: surveyInfo)

    @Query("SELECT * FROM survey_info WHERE questionId = :key")
    fun get(key: Int): surveyInfo?

    @Query("DELETE FROM survey_info")
    fun clear()

    @Query("SELECT * FROM survey_info ORDER BY questionId DESC")
    fun getAllQuestions(): LiveData<List<surveyInfo>>

    @Query("SELECT * FROM survey_info ORDER BY questionId DESC")
    fun getAllAnswers(): LiveData<List<surveyInfo>>

    @Query("SELECT * FROM survey_info ORDER BY questionId DESC LIMIT 1")
    fun getRating(): surveyInfo?

}