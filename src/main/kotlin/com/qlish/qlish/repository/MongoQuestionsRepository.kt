package com.qlish.qlish.repository

import com.qlish.qlish.model.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository

@Repository
class MongoQuestionsRepository(@Autowired private val mongoTemplate: MongoTemplate ): QuestionsRepository {

    override fun getGrammarQuestions(questionLevel:String, questionTopic:String): ResponseEntity<Collection<Question>> {
        val questions = mongoTemplate.findAll(Question::class.java, "grammar.$questionLevel.$questionTopic")
        return ResponseEntity.ok(questions)
    }
    override fun getVocabularyQuestions(questionLevel:String): ResponseEntity<Collection<Question>> {
        val questions = mongoTemplate.findAll(Question::class.java, "vocabulary.$questionLevel")
        return ResponseEntity.ok(questions)
    }
}