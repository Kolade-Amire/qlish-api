package com.qlish.qlish.repository

import com.qlish.qlish.model.Question
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.*
import org.bson.types.ObjectId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus


internal class MongoQuestionsRepositoryTest {

    private lateinit var questionsRepository: MongoQuestionsRepository
    private lateinit var mongoTemplate: MongoTemplate

    @BeforeEach
    fun setUp() {
        mongoTemplate = mockk<MongoTemplate>()
        questionsRepository = MongoQuestionsRepository(mongoTemplate)
    }

    @Test
    fun `should return a response entity with OK STATUS and response body containing collection of GRAMMAR questions for given question level and topic `() {


        //given
        val questionLevel = "advanced"
        val questionTopic = "parts_of_speech"

        val questions = listOf(
            Question(
                ObjectId(),
                "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t","B" to "couldn’t","C" to "may", "D" to "can", "E" to "mightn’t"),
        "grammar",
        "advanced",
        "A"),
            Question(
                ObjectId(),
                "I didn’t ___ ring her up for she did it herself.",
                mapOf("A" to "had to","B" to "could","C" to "be to", "D" to "have to", "E" to "must"),
                "grammar",
                "advanced",
                "D")
        )

        every {mongoTemplate.findAll(Question::class.java, "grammar.$questionLevel.$questionTopic")} returns questions

        //when
        val responseEntity = questionsRepository.getGrammarQuestions(questionLevel, questionTopic)

        //then
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.body).containsExactlyElementsOf(questions)
    }


    @Test
    fun `should return a response entity with OK STATUS and response body containing collection of VOCABULARY questions for given question level `() {


        //given
        val questionLevel = "advanced"

        val questions = listOf(
            Question(
                ObjectId(),
                "If one person is careless with a library book, then it ___ be read by others.",
                mapOf("A" to "can’t","B" to "couldn’t","C" to "may", "D" to "can", "E" to "mightn’t"),
                "vocabulary",
                "advanced",
                "A"),
            Question(
                ObjectId(),
                "I didn’t ___ ring her up for she did it herself.",
                mapOf("A" to "had to","B" to "could","C" to "be to", "D" to "have to", "E" to "must"),
                "vocabulary",
                "advanced",
                "D")
        )

        every {mongoTemplate.findAll(Question::class.java, "vocabulary.$questionLevel")} returns questions

        //when
        val responseEntity = questionsRepository.getVocabularyQuestions(questionLevel)

        //then
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.body).containsExactlyElementsOf(questions)
    }

}