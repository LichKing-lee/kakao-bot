package com.yong.kakaobot.api.skt.weather

data class Precipitation(val sinceOntime: String,
                         val type: String) {
    override fun toString(): String =
            ""
}