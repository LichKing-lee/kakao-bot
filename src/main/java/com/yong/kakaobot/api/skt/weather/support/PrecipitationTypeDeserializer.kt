package com.yong.kakaobot.api.skt.weather.support

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.yong.kakaobot.api.skt.weather.PrecipitationType

class PrecipitationTypeDeserializer: JsonDeserializer<PrecipitationType>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): PrecipitationType {
        return PrecipitationType.of(p.text)
    }
}