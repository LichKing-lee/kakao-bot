package com.yong.kakaobot.api.skt.weather

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@JsonIgnoreProperties(ignoreUnknown = true)
data class Hourly(val grid: Grid,
                  val precipitation: Precipitation,
                  private val sky: Sky,
                  private val temperature: Temperature,
                  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") private val timeRelease: LocalDateTime) {
    override fun toString(): String = "$grid\n$precipitation\n$sky\n$temperature\n갱신시각 : ${dateFormatting()}"

    private fun dateFormatting(): String = timeRelease.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
}