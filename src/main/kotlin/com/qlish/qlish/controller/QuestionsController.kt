package com.qlish.qlish.controller

import com.qlish.qlish.model.Question
import com.qlish.qlish.service.QuestionsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findAll
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/questions")
class QuestionsController(private val service: QuestionsService) {


    @GetMapping("/grammar/{questionLevel}/{question_topic}")
    @ResponseStatus(HttpStatus.OK)
    fun getGrammarQuestions(@PathVariable questionLevel: String, @PathVariable question_topic: String): ResponseEntity<Collection<Question>> = service.retrieveGrammarQuestions(questionLevel, question_topic)



    @GetMapping("/vocabulary/{questionLevel}")
    @ResponseStatus(HttpStatus.OK)
    fun getVocabularyQuestions(@PathVariable questionLevel: String): ResponseEntity<Collection<Question>> = service.retrieveVocabularyQuestions(questionLevel)

}