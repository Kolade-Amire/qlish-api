import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.5"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

group = "com.qlish"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

tasks.jar {
	manifest {
		attributes["Main-Class"] = "com.qlish.qlish.QlishApplication"
	}
}

tasks {
	bootJar {
		from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation ("org.springframework.cloud:spring-cloud-starter-bootstrap:3.0.1")
	testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
	compileOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.mockk:mockk:1.13.4")
	testImplementation ("org.hamcrest:hamcrest-all:1.3")


}


tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}




tasks.withType<Test> {
	useJUnitPlatform()
}
