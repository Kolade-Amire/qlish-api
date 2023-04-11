package com.qlish.qlish.service

import com.qlish.qlish.repository.VocabularyQuestionsRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class VocabularyQuestionsServiceTest {

    private val datasource: VocabularyQuestionsRepository = mockk(relaxed = true)
    private val questionService = VocabularyQuestionsService(datasource)


    @Test
    fun `should call its datasource to retrieve all vocabulary`(){

        //when
        questionService.retrieveAllVocabularyQuestions()

        //then
        verify (exactly = 1){datasource.getAllQuestions() }

    }
}