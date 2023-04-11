package com.qlish.qlish.controller


import com.qlish.qlish.service.GrammarQuestionsService
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class GrammarQuestionsControllerTest(@Autowired val mockMvc: MockMvc) {


    private lateinit var service: GrammarQuestionsService
    val baseUrl = "/api/questions"

    @BeforeEach
    fun setUp() {

        service = mockk<GrammarQuestionsService>(relaxed = true)
    }


    @Nested
    @DisplayName("GET /api/questions/grammar")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAllGrammarQuestions {

        @Test
        fun `should return all grammar questions for the specified question level and topic`() {


            val performGetRequest = mockMvc.get("$baseUrl/grammar")

            performGetRequest.andDo { print() }.andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                }
                jsonPath("$[0].questionClass") { value("grammar") }
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