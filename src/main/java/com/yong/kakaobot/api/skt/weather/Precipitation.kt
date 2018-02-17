package com.yong.kakaobot.api.skt.weather

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.yong.kakaobot.api.skt.weather.support.PrecipitationTypeDeserializer

data class Precipitation(val sinceOntime: String,
                         @JsonDeserialize(using = PrecipitationTypeDeserializer::class) val type: PrecipitationType) {
    override fun toString(): String =
            ""
}