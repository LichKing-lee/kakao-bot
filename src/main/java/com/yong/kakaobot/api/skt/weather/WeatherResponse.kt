package com.yong.kakaobot.api.skt.weather


data class WeatherResponse(val weather: Weather,
                           val common: Common,
                           val result: Result) {
    override fun toString(): String = "$weather\n$common\n\n$result"
}