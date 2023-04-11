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


internal class GrammarQuestionsRepositoryTest {

    private lateinit var questionsRepository: GrammarQuestionsRepository
    private lateinit var mongoTemplate: MongoTemplate

    @BeforeEach
    fun setUp() {
        mongoTemplate = mockk<MongoTemplate>()
        questionsRepository = GrammarQuestionsRepository(mongoTemplate)
    }

    @Test
    fun `should return a response entity with OK STATUS and response body containing collection of all GRAMMAR questions for given question level and topic `() {




        val questions = listOf(
            Question(
                ObjectId(),
                "If one person is careless with a library book, then it ___ be read by others.",
                mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
                "grammar",
                "advanced",
                "sentence completion",
                "A"
            ),
            Question(
                ObjectId(),
                "I didn’t ___ ring her up for she did it herself.",
                mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
                "grammar",
                "advanced",
                "sentence completion",
                "D"
            )
        )

        every { mongoTemplate.findAll(Question::class.java, "grammar") } returns questions

        //when
        val responseEntity = questionsRepository.getAllQuestions()

        //then
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.body).containsAnyElementsOf(questions)
    }


}