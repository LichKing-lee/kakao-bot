package com.yong.kakaobot.api

object ApiUtils {
    fun removeHtml(target: String): String {
        return target.replace("<[a-z/]+>".toRegex(), "")
    }
}