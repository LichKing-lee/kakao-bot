package com.yong.kakaobot.main

import com.yong.kakaobot.request.MessageRequest
import com.yong.kakaobot.response.KeyboardResponse
import com.yong.kakaobot.response.MessageResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {
    @GetMapping("/keyboard")
    fun keyboard(): KeyboardResponse = KeyboardResponse()

    @PostMapping("/message")
    fun message(@RequestBody request: MessageRequest): MessageResponse {
        println(request)
        return MessageResponse(request.content?: "")
    }
}