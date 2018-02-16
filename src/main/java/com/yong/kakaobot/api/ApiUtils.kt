package com.yong.kakaobot.api

object ApiUtils {
    fun removeHtml(target: String): String = target.replace("<[a-z/]+>".toRegex(), "")

    fun mapToQueryString(map: Map<String, String>): String = map.map { "${it.key}=${it.value}" }
            .joinToString(separator = "&")
}