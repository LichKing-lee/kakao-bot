package com.yong.kakaobot.api

import org.springframework.http.ResponseEntity

interface ApiCaller {
    fun <T> callForEntity(url: String, params: Map<String, String>, tClass: Class<T>): ResponseEntity<T>
    fun <T> callForObject(url: String, params: Map<String, String>, tClass: Class<T>): T
}