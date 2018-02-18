package com.yong.kakaobot.main

import com.yong.kakaobot.api.ApiContainer
import com.yong.kakaobot.api.ApiService
import com.yong.kakaobot.api.naver.NaverService
import com.yong.kakaobot.request.MessageRequest
import com.yong.kakaobot.response.KeyboardResponse
import com.yong.kakaobot.response.MessageResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class MainController {
    @Autowired
    private lateinit var apiContainer: ApiContainer

    private val keywords: List<String> = listOf("류다슬", "다슬")
    private val responseMessages: List<String> = listOf("다슬이 안뇽?", "막내괴롭히고있낭", "모찌랑놀지마랍", "살찌고있낭", "팔공산오르고있낭", "퇴직금내놔랍", "쏠거강", "보고시포",
            "야근하낭", "밥묵낭", "볼따구 부풀리낭")

    @GetMapping("/keyboard")
    fun keyboard(): KeyboardResponse = KeyboardResponse()

    @PostMapping("/message")
    fun message(@RequestBody request: MessageRequest): MessageResponse {
        if(keywords.contains(request.content)){
            val randomIdx = Random().nextInt(responseMessages.count())
            return MessageResponse(responseMessages[randomIdx])
        }

        val apiService: ApiService? = apiContainer.get(request.content!!.split(" ")[0])
        val text: String = apiService?.callToApi(request.content!!) ?: helpMessage()

        return MessageResponse(text)
    }

    private fun helpMessage(): String = """
        다음과 같이 입력해주세요.

        영화 [검색단어]
        블로그 [검색단어]
        사전 [검색단어]
        날씨 [시/도 구 동] 예) 날씨 서울 동작구 상도동
    """.trimIndent()
}