package com.qlish.qlish.service

import com.qlish.qlish.repository.GrammarQuestionsRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class GrammarQuestionsServiceTest {

    private val datasource: GrammarQuestionsRepository = mockk(relaxed = true)
    private val questionService = GrammarQuestionsService(datasource)




    @Test
    fun `should call its datasource to retrieve all grammar questions`(){

        //when
        questionService.retrieveAllGrammarQuestions()

        //then
        verify (exactly = 1){datasource.getAllQuestions() }

    }


}