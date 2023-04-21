package com.qlish.qlish.service

import com.qlish.qlish.repository.GrammarQuestionsRepository
import com.qlish.qlish.repository.VocabularyQuestionsRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class VocabularyQuestionsServiceTest {

    private lateinit var datasource: VocabularyQuestionsRepository
    private lateinit var questionService: VocabularyQuestionsService




    @BeforeEach
    fun setUp() {
        datasource = mockk<VocabularyQuestionsRepository>(relaxed = true)
        questionService = VocabularyQuestionsService(datasource)
    }


    @Test
    fun `should call its datasource to retrieve all vocabulary questions`(){

        //when
        questionService.retrieveAllVocabularyQuestions()

        //then
        verify (exactly = 1){datasource.getAllQuestions() }

    }


    @Test
    fun `should call its datasource to retrieve  vocabulary questions by question level`(){

        val questionLevel = "advanced"
        val questionCount = 15L
        //when
        questionService.retrieveVocabularyQuestionsByLevel(questionLevel, questionCount)
        //then
        verify (exactly = 1){datasource.getRandomQuestionsByQuestionLevel(questionLevel, questionCount) }

    }


    @Test
    fun `should call its datasource to retrieve  vocabulary questions by question topic`(){

        val questionTopic = "synonyms"
        val questionCount = 15L
        //when
        questionService.retrieveVocabularyQuestionsByTopic(questionTopic, questionCount)
        //then
        verify (exactly = 1){datasource.getRandomQuestionsByQuestionTopic(questionTopic, questionCount) }

    }


    @Test
    fun `should call its datasource to retrieve  vocabulary questions by question level and topic`(){

        val questionLevel = "advanced"
        val questionTopic = "synonyms"
        val questionCount = 15L
        //when
        questionService.retrieveVocabularyQuestionsByLevelAndTopic(questionLevel,questionTopic, questionCount)
        //then
        verify (exactly = 1){datasource.getRandomQuestionsByQuestionLevelAndTopic(questionLevel, questionTopic, questionCount) }

    }

}