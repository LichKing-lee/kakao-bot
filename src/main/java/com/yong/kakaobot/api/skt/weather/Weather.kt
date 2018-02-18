package com.yong.kakaobot.api.skt.weather

data class Weather(val hourly: List<Hourly>) {
    override fun toString(): String = if(hourly.count() == 0) "조회결과가 없습니다." else hourly[0].toString()
}