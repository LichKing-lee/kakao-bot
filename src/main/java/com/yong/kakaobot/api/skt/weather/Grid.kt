package com.yong.kakaobot.api.skt.weather

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Grid(val city: String,
                val county: String,
                val village: String)