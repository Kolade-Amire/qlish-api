package com.qlish.qlish.repository


import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus

@DataMongoTest
internal class GrammarQuestionsRepositoryTest {

    private lateinit var questionsRepository: GrammarQuestionsRepository
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate
    private val questions = MockQuestions().questions

    @BeforeEach
    fun setUp() {
        mongoTemplate.insertAll(questions)
        questionsRepository = GrammarQuestionsRepository(mongoTemplate)

    }


    @Test
    fun `should return a response entity with OK STATUS and response body containing collection of all GRAMMAR questions`() {


        //when
        val responseEntity = questionsRepository.getAllQuestions()
        //then
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.body).allMatch{it.questionClass == "grammar"}
    }

    @Test
    fun `should return random grammar questions by question level`(){

        //given
        val questionLevel = "advanced"
        val questionCount = 15

        //when
        val responseEntity = questionsRepository.getRandomQuestionsByQuestionLevel(questionLevel, questionCount.toLong())

        //then
        assertThat(responseEntity.body).allMatch{it.questionLevel == questionLevel}
        assertThat(responseEntity.body).allMatch{it.questionClass == "grammar"}
        println(responseEntity.body)



    }

    @Test
    fun `should return random grammar questions by question topic`(){
        val questionTopic = "sentence-completion"
        val questionCount = 15L

        val responseEntity = questionsRepository.getRandomQuestionsByQuestionTopic(questionTopic,questionCount)

        assertThat(responseEntity.body).allMatch{it.questionTopic == questionTopic}
        assertThat(responseEntity.body).allMatch{it.questionClass == "grammar"}
        println(responseEntity.body)

    }

    @Test
    fun `should return random grammar questions by question level and topic`(){

        //given
        val questionTopic = "sentence-completion"
        val questionCount = 15L
        val questionLevel = "advanced"

        //when
        val responseEntity = questionsRepository.getRandomQuestionsByQuestionLevelAndTopic(questionLevel,questionTopic,questionCount)

        //then
        assertThat(responseEntity.body).allMatch{it.questionTopic == questionTopic}
        assertThat(responseEntity.body).allMatch{it.questionClass == "grammar"}
        assertThat(responseEntity.body).allMatch{it.questionLevel == questionLevel}
        println(responseEntity.body)
    }


}
