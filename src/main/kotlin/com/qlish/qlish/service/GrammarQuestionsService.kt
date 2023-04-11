package com.qlish.qlish.service

import com.qlish.qlish.repository.QuestionsRepository
import com.qlish.qlish.model.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class GrammarQuestionsService (@Qualifier("grammar") @Autowired private val datasource: QuestionsRepository) {

    fun retrieveAllGrammarQuestions(): ResponseEntity<Collection<Question>> = datasource.getAllQuestions()

    fun retrieveGrammarQuestionsByLevel(questionLevel: String, questionCount: Long): ResponseEntity<Collection<Question>> = datasource.getRandomQuestionsByQuestionLevel(questionLevel, questionCount)

    fun retrieveGrammarQuestionsByTopic(questionLevel: String, questionCount: Long): ResponseEntity<Collection<Question>> = datasource.getRandomQuestionsByQuestionTopic(questionLevel, questionCount)

    fun retrieveGrammarQuestionsByLevelAndTopic(questionLevel: String, questionTopic: String, questionCount: Long): ResponseEntity<Collection<Question>> = datasource.getRandomQuestionsByQuestionLevelAndTopic(questionLevel, questionTopic, questionCount)
}