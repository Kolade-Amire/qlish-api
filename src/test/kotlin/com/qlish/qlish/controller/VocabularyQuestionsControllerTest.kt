package com.qlish.qlish.controller

import com.qlish.qlish.service.GrammarQuestionsService
import com.qlish.qlish.service.VocabularyQuestionsService
import io.mockk.mockk
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class VocabularyQuestionsControllerTest (@Autowired val mockMvc: MockMvc){

    private lateinit var service: VocabularyQuestionsService
    val baseUrl = "/api/questions/vocabulary"


    @BeforeEach
    fun setUp() {

        service = mockk<VocabularyQuestionsService>(relaxed = true)
    }

    @Nested
    @DisplayName("GET /api/questions/vocabulary")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAllVocabularyQuestions {

        @Test
        fun `should return all VOCABULARY questions for the specified question level`() {

            val performGetRequest = mockMvc.get("$baseUrl/vocabulary")

            performGetRequest.andDo { print() }.andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                }
                jsonPath("$[0].questionClass") { value("vocabulary") }
            }


        }
    }

    @Test
    fun `should return NOT FOUND if the question class does not exist`() {

        //given
        val questionClass = "doesNotExist"
        //when //then
        mockMvc.get("$baseUrl/$questionClass").andDo { print() }
            .andExpect { status { isNotFound() } }
    }
}