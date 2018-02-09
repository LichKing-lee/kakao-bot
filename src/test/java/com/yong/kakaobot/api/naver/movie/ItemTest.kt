package com.yong.kakaobot.api.naver.movie


import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class ItemTest {
    private val item: Item = Item("<b>title</b>",
            "", "", "", "", "", "", "")

    @Test
    fun removeHtml() {
        assertThat(item.title, `is`("<b>title</b>"))
    }
}