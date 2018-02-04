package com.yong.kakaobot.main

import com.yong.kakaobot.request.MessageRequest
import com.yong.kakaobot.response.KeyboardResponse
import com.yong.kakaobot.response.MessageResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class MainController {
    @GetMapping("/keyboard")
    fun keyboard(): KeyboardResponse = KeyboardResponse()

    @PostMapping("/message")
    fun message(@RequestBody request: MessageRequest): MessageResponse {
        val clientId: String = "z0z1bsbO8AeOgIZejE9P"
        val clientSecret: String = "JT7cisjNYQ"
        val restTemplate: RestTemplate = RestTemplate()
        restTemplate.getForEntity("", String::class.java)
        return MessageResponse(request.content?: "")
    }
}