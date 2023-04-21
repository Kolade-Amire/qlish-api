package com.qlish.qlish.repository

import com.qlish.qlish.model.Question
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.bson.types.ObjectId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus

@DataMongoTest
class VocabularyQuestionsRepositoryTest {

    private lateinit var questionsRepository: VocabularyQuestionsRepository
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate
    private val questions = MockQuestions().questions

    @BeforeEach
    fun setUp() {
        mongoTemplate.insertAll(questions)
        questionsRepository = VocabularyQuestionsRepository(mongoTemplate)
    }

    @Test
    fun `should return a response entity with OK STATUS and response body containing collection of all VOCABULARY questions`() {


        //when
        val responseEntity = questionsRepository.getAllQuestions()
        //then
        Assertions.assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(responseEntity.body).allMatch{it.questionClass == "vocabulary"}
    }

    @Test
    fun `should return random grammar questions by question level`(){

        //given
        val questionLevel = "advanced"
        val questionCount = 15

        //when
        val responseEntity = questionsRepository.getRandomQuestionsByQuestionLevel(questionLevel, questionCount.toLong())

        //then
        Assertions.assertThat(responseEntity.body).allMatch{it.questionLevel == questionLevel}
        Assertions.assertThat(responseEntity.body).allMatch{it.questionClass == "vocabulary"}
        println(responseEntity.body)



    }

    @Test
    fun `should return random grammar questions by question topic`(){
        val questionTopic = "synonyms"
        val questionCount = 15L

        val responseEntity = questionsRepository.getRandomQuestionsByQuestionTopic(questionTopic,questionCount)

        Assertions.assertThat(responseEntity.body).allMatch{it.questionTopic == questionTopic}
        Assertions.assertThat(responseEntity.body).allMatch{it.questionClass == "vocabulary"}
        println(responseEntity.body)

    }

    @Test
    fun `should return random grammar questions by question level and topic`(){

        //given
        val questionTopic = "synonyms"
        val questionCount = 15L
        val questionLevel = "advanced"

        //when
        val responseEntity = questionsRepository.getRandomQuestionsByQuestionLevelAndTopic(questionLevel,questionTopic,questionCount)

        //then
        Assertions.assertThat(responseEntity.body).allMatch{it.questionTopic == questionTopic}
        Assertions.assertThat(responseEntity.body).allMatch{it.questionClass == "vocabulary"}
        Assertions.assertThat(responseEntity.body).allMatch{it.questionLevel == questionLevel}
        println(responseEntity.body)
    }



}