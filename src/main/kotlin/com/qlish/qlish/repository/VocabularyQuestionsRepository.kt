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


    override fun getRandom15QuestionsByQuestionLevel(questionLevel: String): ResponseEntity<Collection<Question>> {
        val aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("questionLevel").`is`(questionLevel)),
            Aggregation.sample(15),
            Aggregation.limit(15)
        )
        val questions = mongoTemplate.aggregate(aggregation,"vocabulary", Question::class.java).mappedResults
        return  ResponseEntity.ok(questions)    }


    override fun getRandom25QuestionsByQuestionLevel(
        questionLevel: String
    ): ResponseEntity<Collection<Question>> {
        val aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("questionLevel").`is`(questionLevel)),
            Aggregation.sample(25),
            Aggregation.limit(25)
        )
        val questions = mongoTemplate.aggregate(aggregation,"vocabulary", Question::class.java).mappedResults
        return  ResponseEntity.ok(questions)
    }

    override fun getRandom35QuestionsByQuestionLevel(
        questionLevel: String
    ): ResponseEntity<Collection<Question>> {
        val aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("questionLevel").`is`(questionLevel)),
            Aggregation.sample(35),
            Aggregation.limit(35)
        )
        val questions = mongoTemplate.aggregate(aggregation,"vocabulary", Question::class.java).mappedResults
        return  ResponseEntity.ok(questions)
    }


}