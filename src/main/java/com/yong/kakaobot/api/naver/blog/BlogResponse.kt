package com.yong.kakaobot.api.naver.blog

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.yong.kakaobot.api.naver.movie.support.LocalDateTimeDeserializer
import java.time.LocalDateTime

data class BlogResponse(@JsonDeserialize(using = LocalDateTimeDeserializer::class) val lastBuildDate: LocalDateTime,
                        val total: Int,
                        val start: Int,
                        val display: Int,
                        val items: MutableList<Item>) {
    override fun toString(): String {
        return items.joinToString(separator = "\n\n")
    }
}