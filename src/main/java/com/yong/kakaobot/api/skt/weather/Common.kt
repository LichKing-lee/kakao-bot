package com.yong.kakaobot.api.skt.weather

data class Common(private val alertYn: String,
                  private val stormYn: String) {
    override fun toString(): String = """
        특보유무 : ${if(castBoolean(alertYn)) "특보있음" else "특보없음"}
        태풍유무 : ${if(castBoolean(stormYn)) "태풍있음" else "태풍없음"}
    """.trimMargin()

    private fun castBoolean(str: String): Boolean = str != "N"
}