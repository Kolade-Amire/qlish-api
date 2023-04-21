package com.qlish.qlish.controller


import com.qlish.qlish.service.GrammarQuestionsService
import io.mockk.mockk
import org.hamcrest.core.Every.everyItem
import org.hamcrest.core.IsEqual.equalTo
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
    val baseUrl = "/api/questions/grammar"

    @BeforeEach
    fun setUp() {
        service = mockk<GrammarQuestionsService>(relaxed = true)
    }


    @Nested
    @DisplayName("GET /api/questions/grammar")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetAllGrammarQuestions {

        @Test
        fun `should return all grammar questions`() {

            val performGetRequest = mockMvc.get(baseUrl)
            performGetRequest
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$[*].questionClass", everyItem(equalTo("grammar")))
                }



        }
    }




    @Nested
    @DisplayName("GET /api/questions/grammar/question-level/{questionLevel}/{questionCount}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetGrammarQuestionsByQuestionLevel {

        @Test
        fun `should return random grammar questions with the specified question level`() {


            val questionLevel = "intermediate"
            val questionCount = 15L

            val performGetRequest = mockMvc.get("$baseUrl/question-level/$questionLevel/$questionCount")
            performGetRequest.andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$[*].questionLevel", everyItem(equalTo(questionLevel)))
                }


        }


        @Test
        fun `should return BAD REQUEST if question count is not accepted`(){
            //given
            val questionCount = 33L
            val questionLevel = "advanced"

            //when//then
            mockMvc.get("$baseUrl/question-level/$questionLevel/$questionCount")
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }


        @Test
        fun `should return BAD REQUEST if question level does not exist`(){
            //given
            val questionCount = 15L
            val questionLevel = "expert"

            //when//then
            mockMvc.get("$baseUrl/question-topic/$questionLevel/$questionCount")
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }

    }



    @Nested
    @DisplayName("GET /api/questions/grammar/question-topic/{questionTopic}/{questionCount}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetGrammarQuestionsByQuestionTopic {

        @Test
        fun `should return random grammar questions with the specified question topic`() {


            val questionTopic = "tenses"
            val questionCount = 15L

            val performGetRequest = mockMvc.get("$baseUrl/question-topic/$questionTopic/$questionCount")
            performGetRequest.andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$[*].questionTopic", everyItem(equalTo(questionTopic)))
                }

        }


        @Test
        fun `should return BAD REQUEST if question count is not accepted`(){
            //given
            val questionCount = 33L
            val questionTopic = "tenses"

            //when//then
            mockMvc.get("$baseUrl/question-topic/$questionTopic/$questionCount")
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }

        @Test
        fun `should return BAD REQUEST if question topic does not exist`(){
            //given
            val questionCount = 15L
            val questionTopic = "algebra"

            //when//then
            mockMvc.get("$baseUrl/question-topic/$questionTopic/$questionCount")
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }

    }


    @Nested
    @DisplayName("GET /api/questions/grammar/{questionLevel}/{questionTopic}/{questionCount}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetGrammarQuestionsByQuestionLevelAndTopic {

        @Test
        fun `should return random grammar questions with the specified question level and topic`() {


            val questionLevel = "intermediate"
            val questionTopic = "tenses"
            val questionCount = 15L

            val performGetRequest = mockMvc.get("$baseUrl/$questionLevel/$questionTopic/$questionCount")
            performGetRequest.andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$[*].questionLevel", everyItem(equalTo("intermediate")))
                    jsonPath("$[*].questionTopic", everyItem(equalTo("tenses")))
                }


        }


        @Test
        fun `should return BAD REQUEST if question count is not accepted`(){
            //given
            val questionCount = 33L
            val questionLevel = "advanced"
            val questionTopic = "tenses"

            //when//then
            mockMvc.get("$baseUrl/$questionLevel/$questionTopic/$questionCount")
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }

        @Test
        fun `should return BAD REQUEST if question level and topic is not accepted`(){
            //given
            val questionCount = 15L
            val questionLevel = "expert"
            val questionTopic = "algebra"

            //when//then
            mockMvc.get("$baseUrl/$questionLevel/$questionTopic/$questionCount")
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }

    }


}