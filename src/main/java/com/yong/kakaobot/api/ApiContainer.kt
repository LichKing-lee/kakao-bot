package com.yong.kakaobot.api

import com.yong.kakaobot.api.naver.NaverService
import org.springframework.stereotype.Component

@Component
class ApiContainer(naver: NaverService) {
    private val map: Map<String, NaverService>

    init {
        map = mapOf("블로그" to naver, "영화" to naver, "사전" to naver)
    }

    fun of(key: String): NaverService {
        val a = 3+3f
        val ab = 3+3L
        return map.getOrElse(key, { NaverService() })
    }
}