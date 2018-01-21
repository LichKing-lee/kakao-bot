package com.yong.kakaobot.response;

import lombok.Data;

@Data
public class MessageResponse {
	private Message message;
	private KeyboardResponse keyboard;

	public MessageResponse(String content){
		this.message = new Message(content);
		this.keyboard = new KeyboardResponse();
	}
}
