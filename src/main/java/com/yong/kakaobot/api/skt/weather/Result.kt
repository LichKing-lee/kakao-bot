package com.yong.kakaobot.api.skt.weather

data class Result(val code: Int,
                  val requestUrl: String,
                  val message: String) {
    override fun toString(): String =
            """
                날씨 API 요청결과
                code : $code
                message : $message
                requestUrl : $requestUrl
            """.trimIndent()
}