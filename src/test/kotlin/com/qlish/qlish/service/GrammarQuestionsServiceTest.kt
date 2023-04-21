package com.qlish.qlish.service

import com.qlish.qlish.repository.GrammarQuestionsRepository
import com.qlish.qlish.repository.QuestionsRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner


internal class GrammarQuestionsServiceTest {


    private lateinit var datasource: GrammarQuestionsRepository
    private lateinit var questionService: GrammarQuestionsService




    @BeforeEach
    fun setUp() {
        datasource = mockk<GrammarQuestionsRepository>(relaxed = true)
        questionService = GrammarQuestionsService(datasource)
    }
    @Test
    fun `should call its datasource to retrieve all grammar questions`(){

        //when
        questionService.retrieveAllGrammarQuestions()

        //then
        verify (exactly = 1){datasource.getAllQuestions() }

    }


    @Test
    fun `should call its datasource to retrieve  grammar questions by question level`(){

        val questionLevel = "advanced"
        val questionCount = 15L
        //when
        questionService.retrieveGrammarQuestionsByLevel(questionLevel, questionCount)
        //then
        verify (exactly = 1){datasource.getRandomQuestionsByQuestionLevel(questionLevel, questionCount) }

    }


    @Test
    fun `should call its datasource to retrieve  grammar questions by question topic`(){

        val questionTopic = "sentence-completion"
        val questionCount = 15L
        //when
        questionService.retrieveGrammarQuestionsByTopic(questionTopic, questionCount)
        //then
        verify (exactly = 1){datasource.getRandomQuestionsByQuestionTopic(questionTopic, questionCount) }

    }


    @Test
    fun `should call its datasource to retrieve  grammar questions by question level and topic`(){

        val questionLevel = "advanced"
        val questionTopic = "sentence-completion"
        val questionCount = 15L
        //when
        questionService.retrieveGrammarQuestionsByLevelAndTopic(questionLevel,questionTopic, questionCount)
        //then
        verify (exactly = 1){datasource.getRandomQuestionsByQuestionLevelAndTopic(questionLevel, questionTopic, questionCount) }

    }

}