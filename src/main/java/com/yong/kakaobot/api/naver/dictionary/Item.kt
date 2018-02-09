package com.yong.kakaobot.api.naver.dictionary

data class Item(val title: String,
                val link: String,
                val description: String,
                val thumbnail: String) {
    override fun toString(): String {
        return """
            제목 : $title
            링크 : $link
            설명 : $description
            이미지 : $thumbnail
        """.trimIndent()
    }
}