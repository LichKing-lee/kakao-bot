package com.yong.kakaobot.request

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageRequest(
        @JsonProperty("user_key")
        var userKey:String? = null,
        var type:Type? = null,
        var content:String? = null){

    enum class Type{
        text, photo
    }
}