package com.qlish.qlish.repository

import com.qlish.qlish.model.Question
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository


interface QuestionsRepository{
    fun getGrammarQuestions(questionLevel:String, questionTopic:String): ResponseEntity<Collection<Question>>
    fun getVocabularyQuestions(questionLevel: String): ResponseEntity<Collection<Question>>
}