package com.qlish.qlish.repository

import com.qlish.qlish.model.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository

@Repository("vocabulary")
class VocabularyQuestionsRepository (@Autowired private val mongoTemplate: MongoTemplate): QuestionsRepository {

    override fun getAllQuestions(): ResponseEntity<Collection<Question>> {
        val questions = mongoTemplate.findAll(Question::class.java, "vocabulary")
        return ResponseEntity.ok(questions)
    }


    override fun getRandomQuestionsByQuestionLevel(
        questionLevel: String,
        questionCount: Long
    ): ResponseEntity<Collection<Question>> {
        lateinit var aggregation: Aggregation
        if (questionCount.toInt() == 15 || questionCount.toInt() == 25 || questionCount.toInt() == 35 || questionCount.toInt() == 50){
             aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("questionLevel").`is`(questionLevel)),
                Aggregation.sample(questionCount),
                Aggregation.limit(questionCount)
            )
        }else{
            throw IllegalArgumentException("question count is invalid! accepted parameters are 15, 25, 35 or 50.")
        }

        val questions = mongoTemplate.aggregate(aggregation,"vocabulary", Question::class.java).mappedResults
        return  ResponseEntity.ok(questions)
    }

    override fun getRandomQuestionsByQuestionTopic(
        questionTopic: String,
        questionCount: Long
    ): ResponseEntity<Collection<Question>> {
        lateinit var aggregation: Aggregation
        if (questionCount.toInt() == 15 || questionCount.toInt() == 25 || questionCount.toInt() == 35 || questionCount.toInt() == 50){
            aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("questionTopic").`is`(questionTopic)),
                Aggregation.sample(questionCount),
                Aggregation.limit(questionCount)
            )
        }else{
            throw IllegalArgumentException("question count is invalid! accepted parameters are 15, 25, 35 or 50.")
        }

        val questions = mongoTemplate.aggregate(aggregation,"vocabulary", Question::class.java).mappedResults
        return  ResponseEntity.ok(questions)
    }

    override fun getRandomQuestionsByQuestionLevelAndTopic(
        questionLevel: String,
        questionTopic: String,
        questionCount: Long
    ): ResponseEntity<Collection<Question>> {
        lateinit var aggregation: Aggregation
        if (questionCount.toInt() == 15 || questionCount.toInt() == 25 || questionCount.toInt() == 35 || questionCount.toInt() == 50){
            aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("questionLevel").`is`(questionLevel)),
                Aggregation.match(Criteria.where("questionTopic").`is`(questionTopic)),
                Aggregation.sample(questionCount),
                Aggregation.limit(questionCount)
            )
        }else{
            throw IllegalArgumentException("question count is invalid! accepted parameters are 15, 25, 35 or 50.")
        }

        val questions = mongoTemplate.aggregate(aggregation,"vocabulary", Question::class.java).mappedResults
        return  ResponseEntity.ok(questions)
    }


}