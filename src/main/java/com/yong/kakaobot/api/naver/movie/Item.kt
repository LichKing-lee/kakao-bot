package com.yong.kakaobot.api.naver.movie

data class Item(val title: String,
                val link: String,
                val image: String,
                val subtitle: String,
                val pubDate: String,
                val director: String,
                val actor: String,
                val userRating: String) {
    override fun toString(): String {
        return """
            제목 : ${removeHtml(title)}
            부제 : $subtitle
            네이버영화 : $link
            제작년도 : $pubDate
            감독 : ${director.split("|").joinToString()}
            출연진 : ${actor.split("|").joinToString()}
            평점 : $userRating
        """.trimIndent()
    }

    fun removeHtml(target: String): String {
        return target.replace("<[a-z/]+>".toRegex(), "")
    }
}