package com.qlish.qlish.controller

import com.qlish.qlish.model.Question
import com.qlish.qlish.service.VocabularyQuestionsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/questions/vocabulary")
class VocabularyQuestionsController(@Autowired private val service: VocabularyQuestionsService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.BAD_REQUEST)


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllVocabularyQuestions(): ResponseEntity<Collection<Question>> = service.retrieveAllVocabularyQuestions()


    @GetMapping("/question-level/{questionLevel}/{questionCount}")
    @ResponseStatus(HttpStatus.OK)
    fun getRandomVocabularyQuestionsByQuestionLevel(@PathVariable questionLevel:String, @PathVariable questionCount: Long
    ):ResponseEntity<Collection<Question>> = service.retrieveVocabularyQuestionsByLevel(questionLevel, questionCount)

    @GetMapping("/question-topic/{questionTopic}/{questionCount}")
    @ResponseStatus(HttpStatus.OK)
    fun getRandomVocabularyQuestionsByQuestionTopic(@PathVariable questionTopic:String, @PathVariable questionCount: Long
    ):ResponseEntity<Collection<Question>> = service.retrieveVocabularyQuestionsByTopic(questionTopic, questionCount)


    @GetMapping("/{questionLevel}/{questionTopic}/{questionCount}")
    @ResponseStatus(HttpStatus.OK)
    fun getRandomVocabularyQuestionsByQuestionLevelAndTopic(@PathVariable questionLevel:String,@PathVariable questionTopic: String, @PathVariable questionCount: Long
    ):ResponseEntity<Collection<Question>> = service.retrieveVocabularyQuestionsByLevelAndTopic(questionLevel, questionTopic, questionCount)




}