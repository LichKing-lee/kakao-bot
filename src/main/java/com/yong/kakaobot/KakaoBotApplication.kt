package com.yong.kakaobot

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KakaoBotApplication {
    @Bean
    fun customObjectMapper():ObjectMapper  {
        return jacksonObjectMapper()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KakaoBotApplication::class.java, *args)
}