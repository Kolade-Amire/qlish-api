package com.qlish.qlish.service

import com.qlish.qlish.repository.QuestionsRepository
import com.qlish.qlish.model.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class QuestionsService (@Autowired private val datasource: QuestionsRepository) {

    fun retrieveGrammarQuestions(questionLevel:String, questionTopic:String): ResponseEntity<Collection<Question>> = datasource.getGrammarQuestions(questionLevel, questionTopic)

    fun retrieveVocabularyQuestions(questionLevel: String): ResponseEntity<Collection<Question>> = datasource.getVocabularyQuestions(questionLevel)
}