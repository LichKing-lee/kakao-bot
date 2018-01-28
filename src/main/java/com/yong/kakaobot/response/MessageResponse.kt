package com.yong.kakaobot.response

data class MessageResponse private constructor (val message: Message,
                                                val keyboardResponse: KeyboardResponse){
    constructor(content:String): this(Message(content), KeyboardResponse())
}