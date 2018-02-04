package com.yong.kakaobot

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KakaoBotApplication {
    @Bean
    fun customObjectMapper():ObjectMapper  {
        val mapper: ObjectMapper = jacksonObjectMapper()
        mapper.registerModule(ParameterNamesModule())
        mapper.registerModule(Jdk8Module())
        mapper.registerModule(JavaTimeModule())

        return mapper
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KakaoBotApplication::class.java, *args)
}