package com.yong.kakaobot.api.naver.movie

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.yong.kakaobot.api.naver.movie.support.LocalDateTimeDeserializer
import java.time.LocalDateTime

data class MovieResponse(@JsonDeserialize(using = LocalDateTimeDeserializer::class) val lastBuildDate: LocalDateTime,
                         val total:Int,
                         val start:Int,
                         val display:Int,
                         val items: MutableList<Item>)