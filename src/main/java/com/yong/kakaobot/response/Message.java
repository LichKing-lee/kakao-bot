package com.yong.kakaobot.response;

import lombok.Data;

@Data
public class Message {
	private String text;

	public Message(String content) {
		switch (content) {
			case "뭐해":
				this.text = "일하고있다ㅜㅜ";
				break;
			case "안녕":
				this.text = "안녕!";
				break;
			default:
				this.text = "Hello Kakao Bot";
		}
	}
}
