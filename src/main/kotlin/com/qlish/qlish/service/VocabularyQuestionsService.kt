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

    fun retrieveVocabularyQuestionsByLevel(questionLevel: String, questionCount: Long): ResponseEntity<Collection<Question>> = datasource.getRandomQuestionsByQuestionLevel(questionLevel, questionCount)

    fun retrieveVocabularyQuestionsByTopic(questionLevel: String, questionCount: Long): ResponseEntity<Collection<Question>> = datasource.getRandomQuestionsByQuestionTopic(questionLevel, questionCount)

    fun retrieveVocabularyQuestionsByLevelAndTopic(questionLevel: String, questionTopic: String, questionCount: Long): ResponseEntity<Collection<Question>> = datasource.getRandomQuestionsByQuestionLevelAndTopic(questionLevel, questionTopic, questionCount)
}