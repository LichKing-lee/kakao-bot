package com.yong.kakaobot.api.naver.dictionary

import com.yong.kakaobot.api.ApiUtils

data class Item(val title: String,
                val link: String,
                val description: String,
                val thumbnail: String) {
    override fun toString(): String {
        return """
            이름 : ${ApiUtils.removeHtml(title)}
            설명 : $description
            더보기 : $link
        """.trimIndent()
    }
}