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
            제목 : $title
            부제 : $subtitle
            네이버영화 : $link
            개봉일 : $pubDate
            감독 : ${director.split("|").joinToString()}
            출연진 : ${actor.split("|").joinToString()}
            예매율 : $userRating
        """
    }
}