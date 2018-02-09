package com.yong.kakaobot.api.naver.blog

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.yong.kakaobot.api.ApiUtils
import com.yong.kakaobot.api.naver.blog.support.LocalDateDeserializer
import java.time.LocalDate

data class Item(val title: String,
                val link: String,
                @JsonDeserialize(using = LocalDateDeserializer::class) val postdate: LocalDate,
                val description: String,
                val bloggername: String,
                val bloggerlink: String) {
    override fun toString(): String {
        return """
            제목 : ${ApiUtils.removeHtml(title)}
            검색결과 : ${ApiUtils.removeHtml(description)}
            더보기 : $link
            글쓴날 : $postdate
            블로거 : $bloggername
            블로거링크 : $bloggerlink
        """.trimIndent()
    }
}