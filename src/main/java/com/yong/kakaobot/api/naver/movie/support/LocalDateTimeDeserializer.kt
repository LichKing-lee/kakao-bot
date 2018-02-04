package com.yong.kakaobot.api.naver.movie.support

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class LocalDateTimeDeserializer: JsonDeserializer<LocalDateTime>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): LocalDateTime =
        LocalDateTime.ofInstant(Date(p.text).toInstant(), ZoneId.systemDefault())
}