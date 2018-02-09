package com.yong.kakaobot.api.naver.blog

import com.yong.kakaobot.api.ApiUtils

data class Item(val title: String,
                val link: String,
                val description: String,
                val bloggername: String,
                val bloggerlink: String) {
    override fun toString(): String {
        return """
            제목 : ${ApiUtils.removeHtml(title)}
            검색결과 : ${ApiUtils.removeHtml(description)}
            더보기 : $link
            블로거 : $bloggername
            블로거링크 : $bloggerlink
        """.trimIndent()
    }
}