package com.qlish.qlish.controller

import com.qlish.qlish.model.Question
import com.qlish.qlish.service.GrammarQuestionsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/questions/grammar")
class GrammarQuestionsController(@Autowired private val service: GrammarQuestionsService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.BAD_REQUEST)


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllGrammarQuestions(): ResponseEntity<Collection<Question>> = service.retrieveAllGrammarQuestions()


    @GetMapping("/question-level/{questionLevel}/{questionCount}")
    @ResponseStatus(HttpStatus.OK)
    fun getRandomGrammarQuestionsByQuestionLevel(@PathVariable questionLevel:String, @PathVariable questionCount: Long
    ):ResponseEntity<Collection<Question>> = service.retrieveGrammarQuestionsByLevel(questionLevel, questionCount)

    @GetMapping("/question-topic/{questionTopic}/{questionCount}")
    @ResponseStatus(HttpStatus.OK)
    fun getRandomGrammarQuestionsByQuestionTopic(@PathVariable questionTopic:String, @PathVariable questionCount: Long
    ):ResponseEntity<Collection<Question>> = service.retrieveGrammarQuestionsByTopic(questionTopic, questionCount)


    @GetMapping("/{questionLevel}/{questionTopic}/{questionCount}")
    @ResponseStatus(HttpStatus.OK)
    fun getRandomGrammarQuestionsByQuestionLevelAndTopic(@PathVariable questionLevel:String,@PathVariable questionTopic: String, @PathVariable questionCount: Long
    ):ResponseEntity<Collection<Question>> = service.retrieveGrammarQuestionsByLevelAndTopic(questionLevel, questionTopic, questionCount)


}