package com.yong.kakaobot.api.skt.weather

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Grid(val city: String,
                val county: String,
                val village: String) {
    override fun toString(): String = "기준도시 : $city $county $village"
}