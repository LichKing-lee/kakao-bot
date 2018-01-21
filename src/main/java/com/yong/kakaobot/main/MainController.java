package com.yong.kakaobot.main;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yong.kakaobot.request.MessageRequest;
import com.yong.kakaobot.response.KeyboardResponse;
import com.yong.kakaobot.response.MessageResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {
	@GetMapping("/keyboard")
	public KeyboardResponse keyboard(){
		log.info("hello keyboard");
		return new KeyboardResponse();
	}

	@PostMapping("/message")
	public MessageResponse message(@RequestBody MessageRequest request){
		log.info("content :: {}", request.getContent());
		return new MessageResponse(request.getContent());
	}
}
