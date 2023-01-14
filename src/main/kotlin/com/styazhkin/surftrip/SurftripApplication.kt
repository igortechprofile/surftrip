package com.styazhkin.surftrip

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class SurftripApplication(){
	@RequestMapping("/")
	fun home(): String {
		return "Hello from Spring App running in Docker!"
	}
}

fun main(args: Array<String>) {
	runApplication<SurftripApplication>(*args)
}
