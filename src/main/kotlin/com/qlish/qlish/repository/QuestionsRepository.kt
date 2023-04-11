package com.qlish.qlish.repository

import com.qlish.qlish.model.Question
import org.springframework.http.ResponseEntity


interface QuestionsRepository{
    fun getAllQuestions(): ResponseEntity<Collection<Question>>
    fun getRandomQuestionsByQuestionLevel(questionLevel:String, questionCount: Long): ResponseEntity<Collection<Question>>

    fun getRandomQuestionsByQuestionTopic(questionTopic: String, questionCount: Long): ResponseEntity<Collection<Question>>

    fun getRandomQuestionsByQuestionLevelAndTopic(questionLevel: String, questionTopic: String, questionCount: Long): ResponseEntity<Collection<Question>>

}