package com.yong.kakaobot.api

import com.yong.kakaobot.api.naver.blog.BlogResponse
import com.yong.kakaobot.api.naver.movie.MovieResponse
import com.yong.kakaobot.main.MainController
import org.hamcrest.Matchers.*
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ApiCallerTest {
    @Autowired
    private lateinit var caller: ApiCaller
    val url: String = "https://openapi.naver.com/v1/search/blog.json"

    @Test
    fun inject(){
        assertThat(caller, `is`(notNullValue()))
    }

    @Test
    fun callForEntity() {
        val response: ResponseEntity<BlogResponse> = caller.callForEntity(url, mapOf("query" to "관상"), BlogResponse::class.java)

        assertThat(response.statusCode, `is`(HttpStatus.OK))
//        assertThat(response.body.items, hasSize(2))
    }

    @Test
    fun callForObject() {
        val response: MovieResponse = caller.callForObject(url, mapOf("query" to "관상"), MovieResponse::class.java)

        assertThat(response, `is`(notNullValue()))
        assertThat(response.items, hasSize(2))
    }
}