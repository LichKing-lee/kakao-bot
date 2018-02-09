package com.yong.kakaobot.main

import com.fasterxml.jackson.databind.ObjectMapper
import com.yong.kakaobot.api.ApiCaller
import com.yong.kakaobot.api.naver.dictionary.DictionaryResponse
import com.yong.kakaobot.api.naver.movie.MovieResponse
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
    private lateinit var apiCaller: ApiCaller

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

        if (request.content!!.startsWith("영화")) {
            val response: MovieResponse = apiCaller.callForObject("https://openapi.naver.com/v1/search/movie.json", mapOf("query" to request.content!!.split(" ")[1]), MovieResponse::class.java)
print(response.items[0].pubDate)
            return MessageResponse(response.toString())
        }

        if(request.content!!.startsWith("사전")) {
            val response: DictionaryResponse = apiCaller.callForObject("https://openapi.naver.com/v1/search/encyc.json", mapOf("query" to request.content!!.split(" ")[1]), DictionaryResponse::class.java)
            return MessageResponse(response.toString())
        }

        val text: String = when (request.content) {
            "뭐해" -> "일하고있다ㅜㅜ"
            "안녕" -> "안녕!"
            else -> "Hello KaKao Bot!"
        }
        return MessageResponse(text)
    }
}