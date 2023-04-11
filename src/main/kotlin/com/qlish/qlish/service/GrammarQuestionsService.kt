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

    fun retrieve15QuestionsByLevel(questionLevel: String): ResponseEntity<Collection<Question>> = datasource.getRandom15QuestionsByQuestionLevel(questionLevel)

    fun retrieve25QuestionsByLevel(questionLevel: String): ResponseEntity<Collection<Question>> = datasource.getRandom25QuestionsByQuestionLevel(questionLevel)

    fun retrieve35QuestionsByLevel(questionLevel: String): ResponseEntity<Collection<Question>> = datasource.getRandom35QuestionsByQuestionLevel(questionLevel)
}