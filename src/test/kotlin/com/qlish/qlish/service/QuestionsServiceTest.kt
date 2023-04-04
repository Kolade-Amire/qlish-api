package com.qlish.qlish.service

import com.qlish.qlish.repository.MongoQuestionsRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class QuestionsServiceTest {

    private val datasource: MongoQuestionsRepository = mockk(relaxed = true)
    private val questionService = QuestionsService(datasource)


    @Test
    fun `should call its datasource to retrieve vocabulary questions for question level`(){

        //given
        val questionLevel = "advanced"

        //when
        questionService.retrieveVocabularyQuestions(questionLevel)

        //then
        verify (exactly = 1){datasource.getVocabularyQuestions(questionLevel) }

    }

    @Test
    fun `should call its datasource to retrieve grammar questions for given question level and topic`(){

        //given

        val questionLevel = "advanced"
        val questionTopic = "parts_of_speech"

        //when
        questionService.retrieveGrammarQuestions(questionLevel, questionTopic)

        //then
        verify (exactly = 1){datasource.getGrammarQuestions(questionLevel, questionTopic) }

    }


}