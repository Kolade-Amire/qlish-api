package com.qlish.qlish.controller

import com.qlish.qlish.model.Question
import com.qlish.qlish.service.QuestionsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/questions")
class QuestionsController(private val service: QuestionsService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.BAD_REQUEST)


    @GetMapping("/grammar/{questionLevel}/{questionTopic}")
    @ResponseStatus(HttpStatus.OK)
    fun getGrammarQuestions(@PathVariable questionLevel: String, @PathVariable questionTopic: String): ResponseEntity<Collection<Question>> = service.retrieveGrammarQuestions(questionLevel, questionTopic)



    @GetMapping("/vocabulary/{questionLevel}")
    @ResponseStatus(HttpStatus.OK)
    fun getVocabularyQuestions(@PathVariable questionLevel: String): ResponseEntity<Collection<Question>> = service.retrieveVocabularyQuestions(questionLevel)

}