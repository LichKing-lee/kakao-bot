package com.yong.kakaobot.api.skt.weather

enum class PrecipitationType(val code: String,
                             val message: String) {
    NONE("0", "없음"),
    RAIN("1", "비"),
    RAIN_SNOW("2", "눈, 비"),
    SNOW("3", "눈");

    companion object {
        fun of(code: String): PrecipitationType {
            return values().find { it.code == code } ?: NONE
        }
    }
}