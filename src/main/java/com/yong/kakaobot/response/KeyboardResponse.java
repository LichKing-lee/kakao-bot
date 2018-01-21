package com.yong.kakaobot.response;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class KeyboardResponse {
	private String type;
	private List<String> buttons;

	public KeyboardResponse(){
		this.type = "buttons";
		this.buttons = Arrays.asList("안녕", "뭐해");
	}
}
