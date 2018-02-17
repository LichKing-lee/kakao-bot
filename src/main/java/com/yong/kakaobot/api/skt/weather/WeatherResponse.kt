package com.yong.kakaobot.api.skt.weather


data class WeatherResponse(val weather: Weather,
                           val common: Common,
                           val result: Result)