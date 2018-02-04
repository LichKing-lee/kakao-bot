package com.yong.kakaobot.support

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import com.yong.kakaobot.api.naver.movie.MovieResponse
import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.springframework.http.HttpRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate

class NaverSearchTest: Spek({
    describe("api test") {
        it("search test") {
            val clientId: String = "z0z1bsbO8AeOgIZejE9P"
            val clientSecret: String = "JT7cisjNYQ"
            val api: String = "https://openapi.naver.com/v1/search/movie.json"

            val restTemplate: RestTemplate = RestTemplate()

            val list: MutableList<ClientHttpRequestInterceptor> = mutableListOf(
                    object : ClientHttpRequestInterceptor {
                        override fun intercept(request: HttpRequest, body: ByteArray?, execution: ClientHttpRequestExecution): ClientHttpResponse {
                            request.headers.set("X-Naver-Client-Id", clientId)
                            request.headers.set("X-Naver-Client-Secret", clientSecret)
                            return execution.execute(request, body)
                        }
                    }
            )

            val element = MappingJackson2HttpMessageConverter()
            val jacksonObjectMapper = jacksonObjectMapper()
            jacksonObjectMapper.registerModule(ParameterNamesModule())
            jacksonObjectMapper.registerModule(Jdk8Module())
            jacksonObjectMapper.registerModule(JavaTimeModule())
            element.objectMapper = jacksonObjectMapper
            restTemplate.messageConverters.add(0, element)
            restTemplate.interceptors = list

            val response: ResponseEntity<MovieResponse> = restTemplate.getForEntity("${api}?query=관상", MovieResponse::class.java)

            assertEquals(HttpStatus.OK, response.statusCode)
            println(response.body)
        }
    }
})