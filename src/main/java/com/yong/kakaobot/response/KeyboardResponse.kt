package com.yong.kakaobot.response

data class KeyboardResponse(val type:String = "buttons",
                            val buttons:List<String> = listOf("안녕", "뭐해"))