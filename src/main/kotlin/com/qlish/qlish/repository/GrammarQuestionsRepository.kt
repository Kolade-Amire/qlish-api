package com.qlish.qlish.repository

import com.qlish.qlish.model.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository

@Repository("grammar")
class GrammarQuestionsRepository(@Autowired val mongoTemplate: MongoTemplate) : QuestionsRepository {

    fun singleAggregationMethod(
        aggregationField: String,
        aggregationFieldValue: String,
        questionCount: Long
    ): Aggregation {

        var questionFieldValue: String? = null

        if (questionCount.toInt() in (intArrayOf(15, 25, 35, 50))) {
            when (aggregationField) {
                "questionLevel" -> {
                    if (Values().questionLevels.contains(aggregationFieldValue)) {
                        questionFieldValue = aggregationFieldValue
                    } else {
                        throw IllegalArgumentException("Question level is invalid! Accepted Values are ${Values().questionLevels.asList()}")
                    }
                }

                "questionTopic" -> {
                    if (aggregationFieldValue in Values().grammarQuestionTopics) {
                        questionFieldValue = aggregationFieldValue
                    } else {
                        throw IllegalArgumentException("Question topic is invalid! Accepted Values are ${Values().grammarQuestionTopics.asList()}")
                    }
                }
            }

        } else {
            throw IllegalArgumentException("question count is invalid! Accepted parameters are 15, 25, 35 or 50.")
        }

        return Aggregation.newAggregation(
            Aggregation.match(Criteria.where(aggregationField).`is`(questionFieldValue)),
            Aggregation.sample(questionCount),
            Aggregation.limit(questionCount)
        )
    }

    fun doubleAggregationMethod(
        questionLevel: String,
        questionTopic: String,
        questionCount: Long
    ): Aggregation {

        if (questionCount.toInt() in (intArrayOf(15, 25, 35, 50))) {
            if (questionLevel in Values().questionLevels && questionTopic in Values().grammarQuestionTopics) {
                return Aggregation.newAggregation(
                    Aggregation.match(Criteria.where("questionLevel").`is`(questionLevel)),
                    Aggregation.match(Criteria.where("questionTopic").`is`(questionTopic)),
                    Aggregation.sample(questionCount),
                    Aggregation.limit(questionCount)
                )
            } else {
                throw IllegalArgumentException(
                    "Question level or topic is invalid! Accepted parameters are\n" +
                            "questionLevel: ${Values().questionLevels.asList()}\n" +
                            "questionTopic: ${Values().grammarQuestionTopics.asList()}"
                )

            }
        } else {
            throw IllegalArgumentException("Question count is invalid! Accepted parameters are 15, 25, 35 or 50.")
        }

    }


    override fun getAllQuestions(): ResponseEntity<Collection<Question>> {
        val questions = mongoTemplate.findAll(Question::class.java, "grammar")
        return ResponseEntity.ok(questions)
    }

    override fun getRandomQuestionsByQuestionLevel(
        questionLevel: String,
        questionCount: Long
    ): ResponseEntity<Collection<Question>> {

        val aggregation = singleAggregationMethod("questionLevel", questionLevel, questionCount)
        val questions = mongoTemplate.aggregate(aggregation, "grammar", Question::class.java).mappedResults
        return ResponseEntity.ok(questions)
    }


    override fun getRandomQuestionsByQuestionTopic(
        questionTopic: String,
        questionCount: Long
    ): ResponseEntity<Collection<Question>> {
        val aggregation = singleAggregationMethod("questionTopic", questionTopic, questionCount)
        val questions = mongoTemplate.aggregate(aggregation, "grammar", Question::class.java).mappedResults
        return ResponseEntity.ok(questions)
    }


    override fun getRandomQuestionsByQuestionLevelAndTopic(
        questionLevel: String,
        questionTopic: String,
        questionCount: Long
    ): ResponseEntity<Collection<Question>> {
        val aggregation = doubleAggregationMethod(questionLevel, questionTopic, questionCount)

        val questions = mongoTemplate.aggregate(aggregation, "grammar", Question::class.java).mappedResults
        return ResponseEntity.ok(questions)
    }
}