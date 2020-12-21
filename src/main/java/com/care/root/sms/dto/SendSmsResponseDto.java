package com.care.root.sms.dto;

import java.security.Timestamp;

import org.springframework.context.annotation.Configuration;
@Configuration
public class SendSmsResponseDto {
	private String statusCode; 
	private String statusName; 
	private String requestId; 
	private Timestamp requestTime;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public Timestamp getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	} 
	
	
}

