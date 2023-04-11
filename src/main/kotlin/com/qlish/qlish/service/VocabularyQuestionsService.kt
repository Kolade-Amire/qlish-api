package com.qlish.qlish.service

import com.qlish.qlish.model.Question
import com.qlish.qlish.repository.QuestionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class VocabularyQuestionsService (@Qualifier("vocabulary") @Autowired private val datasource:QuestionsRepository) {

    fun retrieveAllVocabularyQuestions(): ResponseEntity<Collection<Question>> = datasource.getAllQuestions()

    fun retrieve15QuestionsBLevel(questionLevel: String): ResponseEntity<Collection<Question>> = datasource.getRandom15QuestionsByQuestionLevel(questionLevel)

    fun retrieve25QuestionsByLevel(questionLevel: String): ResponseEntity<Collection<Question>> = datasource.getRandom25QuestionsByQuestionLevel(questionLevel)

    fun retrieve35QuestionsByLevel(questionLevel: String): ResponseEntity<Collection<Question>> = datasource.getRandom35QuestionsByQuestionLevel(questionLevel)
}