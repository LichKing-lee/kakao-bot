package com.yong.kakaobot.api.skt.weather

data class Sky(val code: String,
               val name: String) {
    override fun toString(): String = "하늘상태 : $name"
}