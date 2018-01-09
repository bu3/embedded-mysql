package io.github.bu3.embeddedmysql

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class EmbeddedMysqlApplication

fun main(args: Array<String>) {
    SpringApplication.run(EmbeddedMysqlApplication::class.java, *args)
}
