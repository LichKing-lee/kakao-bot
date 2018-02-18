package com.yong.kakaobot.api.skt

import com.yong.kakaobot.api.ApiCaller
import com.yong.kakaobot.api.ApiService
import com.yong.kakaobot.api.skt.weather.WeatherResponse
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class SktService: ApiService {
    @Resource(name = "sktApiCaller")
    private lateinit var apiCaller: ApiCaller

    override fun callToApi(keyword: String): String {
        val params: Map<String, String> = mapOf("city" to "서울", "county" to "동작구", "village" to "사당동")
        val response: WeatherResponse = apiCaller.callForObject("https://api2.sktelecom.com/weather/current/hourly", params, WeatherResponse::class.java)
        return response.toString()
    }
}