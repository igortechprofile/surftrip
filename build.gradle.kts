import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

//sourceSets {
//	main {
//		java.srcDir("src/main/kotlin")
//	}
//	test {
//		java.srcDir("src/test/kotlin")
//	}
//}

group = "com.styazhkin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
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

tasks.getByName<Jar>("jar") {
	enabled = false
}
//tasks.withType<Jar>{
//	manifest {
//		attributes["Main-Class"] = "com.styazhkin.surftrip.SurftripApplicationKt"
//	}
//}

//tasks.withType<org.gradle.jvm.tasks.Jar> {
//	enabled = true
//	includeEmptyDirs = false
//	manifest {
//		attributes(
//			mapOf(
//				"Implementation-Title" to project.description,
//				"Implementation-Version" to project.version,
//				"Main-Class" to "com.styazhkin.surftrip.SurftripApplicationKt"
//			)
//		)
//	}
//	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//	from({
//		configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
//	})
//}