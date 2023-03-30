package com.qlish.qlish.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("Question")
data class Question(
    @Id
    val id: ObjectId? =null,
    @Field("question")
    val questionBody: String,
    val options: Map<String, String>,
    val questionClass: String,
    val questionLevel: String,
    val answer: String
)
