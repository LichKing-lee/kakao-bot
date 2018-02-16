package com.yong.kakaobot.api.skt

import com.yong.kakaobot.api.ApiCaller
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@SpringBootTest
class SktApiCallerTest {
    @Resource(name = "sktApiCaller")
    lateinit var caller: ApiCaller

    @Test
    fun callForEntity() {
        val response: ResponseEntity<Map<*, *>> = caller.callForEntity("https://api2.sktelecom.com/weather/summary", mapOf("lat" to "37.5660649", "lon" to "126.9826791"), Map::class.java)

        assertThat(response.statusCode, `is`(HttpStatus.OK))
    }

    @Test
    fun callForObject() {
    }
}