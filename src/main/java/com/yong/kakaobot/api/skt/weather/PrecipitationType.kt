package com.yong.kakaobot.api.skt.weather

enum class PrecipitationType(private val code: String) {
    NONE("0"),
    RAIN("1"),
    RAIN_SNOW("2"),
    SNOW("3");

    companion object {
        fun of(code: String): PrecipitationType {
            return values().find { it.code == code } ?: NONE
        }
    }
}