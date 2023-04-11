package com.qlish.qlish.repository

import com.qlish.qlish.model.Question
import org.springframework.http.ResponseEntity


interface QuestionsRepository{
    fun getAllQuestions(): ResponseEntity<Collection<Question>>
    fun getRandom15QuestionsByQuestionLevel(questionLevel:String): ResponseEntity<Collection<Question>>
    fun getRandom25QuestionsByQuestionLevel(questionLevel:String): ResponseEntity<Collection<Question>>

    fun getRandom35QuestionsByQuestionLevel(questionLevel:String): ResponseEntity<Collection<Question>>

}