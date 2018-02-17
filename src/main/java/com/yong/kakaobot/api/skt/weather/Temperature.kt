package com.yong.kakaobot.api.skt.weather

data class Temperature(private val tc: String,
                       private val tmax: String,
                       private val tmin: String) {
    override fun toString(): String = "현재온도 : $tc\n최고온도 : $tmax\n최저온도 : $tmin"
}