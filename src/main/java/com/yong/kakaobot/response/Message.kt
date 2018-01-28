package com.yong.kakaobot.response

data class Message(private val param: String) {
    val text:String = when(param) {
        "뭐해" -> "일하고있다ㅜㅜ"
        "안녕" -> "안녕!"
        else -> "Hello KaKao Bot!"
    }
}