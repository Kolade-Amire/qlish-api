package com.qlish.qlish.controller


import com.qlish.qlish.service.QuestionsService
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
internal class QuestionsControllerTest (@Autowired val mockMvc: MockMvc){


    private lateinit var service: QuestionsService
    val baseUrl = "/api/questions"

    @BeforeEach
    fun setUp() {

        service = mockk<QuestionsService>(relaxed = true)
    }


    @Nested
    @DisplayName("GET /api/questions/grammar/{questionLevel}/{question_topic}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetGrammarQuestions {

        @Test
        fun `should return all grammar questions for the specified question level and topic` (){

            //given
            val questionLevel = "advanced"
            val questionTopic = "parts_of_speech"


            //when//then
            val performGetRequest = mockMvc.get("$baseUrl/grammar/$questionLevel/$questionTopic")


            performGetRequest
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$[0].questionClass") {value("grammar")}
                }
        }
    }

    @Test
    fun `should return NOT FOUND if the GRAMMAR question topic or level does not exist` () {

        //given
        val questionLevel = "advanced"
        val questionTopic = "null"

        //when //then
        mockMvc.get ( "$baseUrl/$questionLevel/$questionTopic")
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }

    @Nested
    @DisplayName("GET /api/questions/vocabulary/{questionLevel}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetVocabularyQuestions {


        @Test
        fun `should return all VOCABULARY questions for the specified question level`(){
            //given
            val questionLevel = "elementary"


            //when//then
            val performGetRequest = mockMvc.get("$baseUrl/vocabulary/$questionLevel")


            performGetRequest
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$[0].questionClass") {value("vocabulary")}
                }


        }
    }

    @Test
    fun `should return NOT FOUND if the VOCABULARY question level does not exist` () {

        //given
        val questionLevel = "invalid"

        //when //then
        mockMvc.get ( "$baseUrl/$questionLevel")
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }

}