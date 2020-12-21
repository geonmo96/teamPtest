package com.care.root.sms.dto;

import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsRequestDto {
	private String type;
	private String contentType;
	private String countryCode;
	private String from;
	private String content;
	private List<MessagesRequestDto> messages;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<MessagesRequestDto> getMessages() {
		return messages;
	}
	public void setMessages(List<MessagesRequestDto> messages) {
		this.messages = messages;
	}
	
	
}
