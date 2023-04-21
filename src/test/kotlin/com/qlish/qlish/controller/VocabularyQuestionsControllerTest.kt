package com.qlish.qlish.controller

import com.qlish.qlish.service.VocabularyQuestionsService
import io.mockk.mockk
import org.hamcrest.core.Every.everyItem
import org.hamcrest.core.IsEqual
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
        fun `should return all vocabulary questions`() {

            val performGetRequest = mockMvc.get(baseUrl)
            performGetRequest
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$[*].questionClass", everyItem(IsEqual.equalTo("vocabulary")))
                }

        }
    }




    @Nested
    @DisplayName("GET /api/questions/vocabulary/question-level/{questionLevel}/{questionCount}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetVocabularyQuestionsByQuestionLevel {

        @Test
        fun `should return random vocabulary questions with the specified question level and count`() {


            val questionLevel = "elementary"
            val questionCount = 15L

            val performGetRequest = mockMvc.get("$baseUrl/question-level/$questionLevel/$questionCount")
            performGetRequest.andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$[*].questionLevel", everyItem(IsEqual.equalTo(questionLevel)))
                }

        }


        @Test
        fun `should return BAD REQUEST if question count is not accepted`(){
            //given
            val questionCount = 33L
            val questionLevel = "elementary"

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
            mockMvc.get("$baseUrl/question-level/$questionLevel/$questionCount")
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }

    }



    @Nested
    @DisplayName("GET /api/questions/vocabulary/question-topic/{questionTopic}/{questionCount}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetVocabularyQuestionsByQuestionTopic {

        @Test
        fun `should return random vocabulary questions with the specified question topic and count`() {


            val questionTopic = "paragraph"
            val questionCount = 15L

            val performGetRequest = mockMvc.get("$baseUrl/question-topic/$questionTopic/$questionCount")
            performGetRequest.andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$[*].questionTopic", everyItem(IsEqual.equalTo(questionTopic)))
                }

        }


        @Test
        fun `should return BAD REQUEST if question count is not accepted`(){
            //given
            val questionCount = 33L
            val questionTopic = "antonyms"

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
    @DisplayName("GET /api/questions/vocabulary/{questionLevel}/{questionTopic}/{questionCount}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetGrammarQuestionsByQuestionLevelAndTopic {

        @Test
        fun `should return random vocabulary questions with the specified question level and topic`() {


            val questionLevel = "advanced"
            val questionTopic = "synonyms"
            val questionCount = 15L

            val performGetRequest = mockMvc.get("$baseUrl/$questionLevel/$questionTopic/$questionCount")
            performGetRequest.andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$[*].questionLevel", everyItem(IsEqual.equalTo(questionLevel)))
                    jsonPath("$[*].questionTopic", everyItem(IsEqual.equalTo(questionTopic)))
                }

        }


        @Test
        fun `should return BAD REQUEST if question count is not accepted`(){
            //given
            val questionCount = 33L
            val questionLevel = "advanced"
            val questionTopic = "synonyms"

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