package com.yong.kakaobot.api.naver.movie

data class Item(val title: String,
                val link: String,
                val image: String,
                val subtitle: String,
                val pubDate: String,
                val director: String,
                val actor: String,
                val userRating: String)