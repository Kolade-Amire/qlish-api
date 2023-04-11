package com.qlish.qlish.controller

import com.qlish.qlish.model.Question
import com.qlish.qlish.service.VocabularyQuestionsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/questions/vocabulary")
class VocabularyQuestionsController(@Autowired private val service: VocabularyQuestionsService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.BAD_REQUEST)


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllVocabularyQuestions(): ResponseEntity<Collection<Question>> = service.retrieveAllVocabularyQuestions()


    @GetMapping("/{questionLevel}/15")
    @ResponseStatus(HttpStatus.OK)
    fun getRandom15QuestionsByQuestionLevel(@PathVariable questionLevel:String):ResponseEntity<Collection<Question>> = service.retrieve15QuestionsBLevel(questionLevel)


    @GetMapping("/{questionLevel}/25")
    @ResponseStatus(HttpStatus.OK)
    fun getRandom25QuestionsByQuestionLevel(@PathVariable questionLevel:String):ResponseEntity<Collection<Question>> = service.retrieve25QuestionsByLevel(questionLevel)

    @GetMapping("/{questionLevel}/35")
    @ResponseStatus(HttpStatus.OK)
    fun getRandom35QuestionsByQuestionLevel(@PathVariable questionLevel:String):ResponseEntity<Collection<Question>> = service.retrieve35QuestionsByLevel(questionLevel)



}