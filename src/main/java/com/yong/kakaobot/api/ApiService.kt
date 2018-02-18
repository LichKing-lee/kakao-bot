package com.yong.kakaobot.api

interface ApiService {
    fun callToApi(keyword: String): String
}