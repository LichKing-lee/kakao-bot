package com.yong.kakaobot.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageRequest {
	@JsonProperty("user_key")
	private String userKey;
	private Type type;
	private String content;

	enum Type{
		text, photo
	}
}
