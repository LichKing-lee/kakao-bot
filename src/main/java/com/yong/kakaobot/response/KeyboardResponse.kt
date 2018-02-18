package com.yong.kakaobot.response

data class KeyboardResponse(val type:String = "buttons",
                            val buttons:List<String> = listOf("사용법확인"))