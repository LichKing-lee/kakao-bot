package com.yong.kakaobot.api.naver.blog.support

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LocalDateDeserializer : JsonDeserializer<LocalDate>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): LocalDate {
        return LocalDate.parse(p!!.text, DateTimeFormatter.ofPattern("yyyyMMdd"))
    }
}