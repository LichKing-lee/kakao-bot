package com.yong.kakaobot.main;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void keyboard() throws Exception {
		mockMvc.perform(get("/keyboard"))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.type").value("buttons"))
			.andExpect(jsonPath("$.buttons[0]").value("안녕"))
			.andExpect(jsonPath("$.buttons[1]").value("뭐해"));
	}

	@Test
	public void message() throws Exception {
		mockMvc.perform(post("/message")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.content("{\"user_key\":\"\",\"type\":\"text\",\"content\":\"뭐해\"}"))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.message.text").value("일하고있다ㅜㅜ"));
	}
}