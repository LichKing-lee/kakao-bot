package com.yong.kakaobot.main

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class KotlinMainControllerTest {
    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    fun keyboard() {
        mockMvc!!.perform(get("/keyboard"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.type").value("buttons"))
                .andExpect(jsonPath("$.buttons[0]").value("안녕"))
                .andExpect(jsonPath("$.buttons[1]").value("뭐해"))
    }

    @Test
    fun message() {
        mockMvc!!.perform(post("/message")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"user_key\":\"\",\"type\":\"text\",\"content\":\"뭐해\"}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.message.text").value("일하고있다ㅜㅜ"))
    }
}