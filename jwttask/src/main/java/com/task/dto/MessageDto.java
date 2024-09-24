package com.task.dto;


import org.springframework.stereotype.Component;

@Component
public class MessageDto {
	
	private String Msg;

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

}
