package com.yong.kakaobot.api

import com.yong.kakaobot.api.naver.NaverService
import com.yong.kakaobot.api.skt.SktService
import org.springframework.stereotype.Component

@Component
class ApiContainer(naver: NaverService,
                   skt: SktService) {
    private val map: Map<String, ApiService>

    init {
        map = mapOf("블로그" to naver, "영화" to naver, "사전" to naver, "날씨" to skt)
    }

    fun get(key: String): ApiService? {
        return map[key]
    }
}