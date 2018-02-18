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

    companion object {
        val DEFAULT_PARAMS: Map<String, String> = mapOf("city" to "서울", "county" to "동작구", "village" to "사당동")
    }

    override fun callToApi(keyword: String): String {
        val params: Map<String, String> = createParams(keyword.split(" "))
        val response: WeatherResponse = apiCaller.callForObject("https://api2.sktelecom.com/weather/current/hourly", params, WeatherResponse::class.java)
        return response.toString()
    }

    private fun createParams(keywords: List<String>): Map<String, String> {
        if(keywords.count() == 4) {
            return mapOf("city" to keywords[1], "county" to keywords[2], "village" to keywords[3])
        }

        if(keywords.count() == 5) {
            return mapOf("city" to keywords[1], "county" to "${keywords[2]} ${keywords[3]}", "village" to keywords[4])
        }

        return DEFAULT_PARAMS
    }
}