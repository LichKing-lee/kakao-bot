package com.yong.kakaobot.api.naver.movie

import java.time.LocalDateTime
import java.util.*

data class MovieResponse(val lastBuildDate: Date,
                         val total:Int,
                         val start:Int,
                         val display:Int,
                         val items: MutableList<Item>)