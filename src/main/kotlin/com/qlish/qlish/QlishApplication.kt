package com.qlish.qlish

import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@Configuration
class QlishApplication{



	@Value("\${spring.data.mongodb.uri}")
	lateinit var connectionString: String
	@Bean
	fun mongoTemplate(): MongoTemplate {
		val mongoClient = MongoClients.create(connectionString)
		val databaseFactory = SimpleMongoClientDatabaseFactory(mongoClient, "Questions")
		return MongoTemplate(databaseFactory)
	}
}

fun main(args: Array<String>) {
	runApplication<QlishApplication>(*args)

}
