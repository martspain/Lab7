package com.example.lab6.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "survey_info")
data class surveyInfo (
    @PrimaryKey(autoGenerate = true)
    var questionId: Int = 0,

    @ColumnInfo(name = "question")
    val questions: String = "¿Qué le pareció nuestro servicio?",

    @ColumnInfo(name = "answer")
    var answers: String = "None",

    @ColumnInfo(name = "type")
    var type: String = "Normal"

)