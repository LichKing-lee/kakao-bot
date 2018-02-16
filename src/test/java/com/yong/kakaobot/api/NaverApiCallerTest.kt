package com.yong.kakaobot.api

import com.yong.kakaobot.api.naver.NaverApiCaller
import com.yong.kakaobot.api.naver.blog.BlogResponse
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class NaverApiCallerTest {
    @Autowired
    private lateinit var callerNaver: NaverApiCaller
    val url: String = "https://openapi.naver.com/v1/search/blog.json"

    @Test
    fun inject(){
        assertThat(callerNaver, `is`(notNullValue()))
    }

    @Test
    fun callForEntity() {
        val response: ResponseEntity<BlogResponse> = callerNaver.callForEntity(url, mapOf("query" to "관상"), BlogResponse::class.java)

        assertThat(response.statusCode, `is`(HttpStatus.OK))
//        assertThat(response.body.items, hasSize(2))
    }

    @Test
    fun callForObject() {
        val response: BlogResponse = callerNaver.callForObject(url, mapOf("query" to "관상"), BlogResponse::class.java)

        assertThat(response, `is`(notNullValue()))
//        assertThat(response.items, hasSize(2))
    }
}