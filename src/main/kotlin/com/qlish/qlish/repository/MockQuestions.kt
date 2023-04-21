package com.qlish.qlish.repository

import com.qlish.qlish.model.Question
import org.bson.Document
import org.bson.types.ObjectId

class MockQuestions {



    private val mockDocuments:MutableList<Document> = mutableListOf()
    val questions = listOf(
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "grammar",
            "advanced",
            "sentence-completion",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "grammar",
            "advanced",
            "sentence-completion",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "grammar",
            "advanced",
            "parts-of-speech",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "grammar",
            "advanced",
            "sentence-completion",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "grammar",
            "advanced",
            "sentence-completion",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "grammar",
            "advanced",
            "parts-of-speech",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "grammar",
            "advanced",
            "sentence-completion",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "grammar",
            "advanced",
            "sentence-completion",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "grammar",
            "advanced",
            "parts-of-speech",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "grammar",
            "advanced",
            "sentence-completion",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "grammar",
            "advanced",
            "sentence-completion",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "grammar",
            "advanced",
            "parts-of-speech",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "grammar",
            "advanced",
            "sentence-completion",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "grammar",
            "advanced",
            "sentence-completion",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "grammar",
            "advanced",
            "parts-of-speech",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "grammar",
            "advanced",
            "sentence-completion",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "grammar",
            "advanced",
            "sentence-completion",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "grammar",
            "advanced",
            "parts-of-speech",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "grammar",
            "advanced",
            "sentence-completion",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "grammar",
            "advanced",
            "sentence-completion",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "grammar",
            "advanced",
            "parts-of-speech",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "grammar",
            "advanced",
            "sentence-completion",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "grammar",
            "advanced",
            "sentence-completion",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "grammar",
            "advanced",
            "parts-of-speech",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "vocabulary",
            "advanced",
            "synonyms",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "vocabulary",
            "advanced",
            "synonyms",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "vocabulary",
            "advanced",
            "synonyms",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "vocabulary",
            "advanced",
            "synonyms",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "vocabulary",
            "advanced",
            "synonyms",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "vocabulary",
            "advanced",
            "synonyms",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "vocabulary",
            "advanced",
            "synonyms",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "vocabulary",
            "advanced",
            "synonyms",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "If one person is careless with a library book, then it ___ be read by others.",
            mapOf("A" to "can’t", "B" to "couldn’t", "C" to "may", "D" to "can", "E" to "mightn’t"),
            "vocabulary",
            "advanced",
            "synonyms",
            "A"
        ),
        Question(
            ObjectId(),
            "I didn’t ___ ring her up for she did it herself.",
            mapOf("A" to "had to", "B" to "could", "C" to "be to", "D" to "have to", "E" to "must"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        ),
        Question(
            ObjectId(),
            "You ___ do this work yourself, if you try.",
            mapOf("A" to "can", "B" to "had to", "C" to "must", "D" to "was able to", "E" to "were to do"),
            "vocabulary",
            "advanced",
            "synonyms",
            "D"
        )
    )

    init {


        for ((index, question) in questions.withIndex()){
            val document = Document("_id", ObjectId())
                .append("question", question.questionBody)
                .append("options", question.options)
                .append("questionLevel", question.questionLevel)
                .append("questionClass", question.questionClass)
                .append("questionTopic", question.questionTopic)
                .append("answer", question.answer)
            mockDocuments.add(index, document)
        }
    }
}