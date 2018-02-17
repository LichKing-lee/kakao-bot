package com.yong.kakaobot.api.skt

import com.fasterxml.jackson.databind.ObjectMapper
import com.yong.kakaobot.api.ApiCaller
import com.yong.kakaobot.api.skt.weather.PrecipitationType
import com.yong.kakaobot.api.skt.weather.WeatherResponse
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@SpringBootTest
class SktApiCallerTest {
    @Resource(name = "sktApiCaller")
    lateinit var caller: ApiCaller
    @Resource(name = "customObjectMapper")
    lateinit var mapper: ObjectMapper

    @Test
    fun deserialize() {


        val json: String = """
            {
  "weather": {
    "hourly": [{
      "grid": {
        "latitude": "37.57988",
        "longitude": "126.98936",
        "city": "서울",
        "county": "종로구",
        "village": "원서동"
      },
      "wind": {
        "wdir": "275.00",
        "wspd": "3.80"
      },
      "precipitation": {
        "sinceOntime": "0.00",
        "type": "2"
      },
      "sky": {
        "code": "SKY_O03",
        "name": "구름많음"
      },
      "temperature": {
        "tc": "2.60",
        "tmax": "4.00",
        "tmin": "-4.00"
      },
      "humidity": "27.00",
      "lightning": "0",
      "timeRelease": "2018-02-16 15:00:00"
    }]
  },
  "common": {
    "alertYn": "Y",
    "stormYn": "N"
  },
  "result": {
    "code": 9200,
    "requestUrl": "/weather/current/hourly?version=1&lat=37.5660649&lon=126.9826791",
    "message": "성공"
  }
}
        """.trimIndent()

        val response: WeatherResponse = mapper.readValue(json, WeatherResponse::class.java)

        assertThat(response.weather.hourly[0].precipitation.type, `is`(PrecipitationType.RAIN_SNOW))
    }

    @Test
    fun callForEntity() {
        val response: ResponseEntity<WeatherResponse> = caller.callForEntity("https://api2.sktelecom.com/weather/current/hourly", mapOf("lat" to "37.5660649", "lon" to "126.9826791"), WeatherResponse::class.java)

        assertThat(response.statusCode, `is`(HttpStatus.OK))
    }

    @Test
    fun callForObject() {
        val params = mapOf("city" to "서울", "county" to "동작구", "village" to "사당동")
        val response: WeatherResponse = caller.callForObject("https://api2.sktelecom.com/weather/current/hourly", params, WeatherResponse::class.java)

        assertThat(response.result.code, `is`(9200))
        assertThat(response.result.message, `is`("성공"))
        assertThat(response.weather.hourly[0].grid.city, `is`("서울"))
    }
}