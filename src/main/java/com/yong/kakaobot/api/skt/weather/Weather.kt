package com.yong.kakaobot.api.skt.weather

data class Weather(val hourly: List<Hourly>) {
    override fun toString(): String = "${hourly[0]}"
}