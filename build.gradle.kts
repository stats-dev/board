plugins {
	java
	id("org.springframework.boot") version "2.7.12"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.study"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.12")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.7.8")
	implementation("org.springframework.boot:spring-boot-starter-web:2.7.12")
    implementation("org.projectlombok:lombok:1.18.26")
	implementation("org.projectlombok:lombok:1.18.26")
	implementation("org.projectlombok:lombok:1.18.26")
	implementation("org.projectlombok:lombok:1.18.26")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.1.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.8")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
