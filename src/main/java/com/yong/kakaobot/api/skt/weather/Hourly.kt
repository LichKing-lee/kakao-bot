package com.yong.kakaobot.api.skt.weather

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Hourly(val grid: Grid,
                  val precipitation: Precipitation,
                  val sky: Sky,
                  val temperature: Temperature,
                  val timeRelease: String) {
    override fun toString(): String = ""
}