package com.care.root.member.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.care.root.sms.dto.MessagesRequestDto;
import com.care.root.sms.dto.SendSmsResponseDto;
import com.care.root.sms.dto.SmsRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class NaverSmsServiceImpl {

	public SendSmsResponseDto sendSms(String recipientPhoneNumber, String content) {
		SendSmsResponseDto sendSmsResponseDto = null;
		try {
			Long time = System.currentTimeMillis();
			ObjectMapper objectMapper = new ObjectMapper(); 
			
			SmsRequestDto smsRequestDto = new SmsRequestDto(); 
			smsRequestDto.setType("SMS");
			smsRequestDto.setContentType("COMM");
			smsRequestDto.setCountryCode("82");
			smsRequestDto.setFrom(recipientPhoneNumber);
			smsRequestDto.setContent(content);
			List<MessagesRequestDto> messages = new ArrayList<MessagesRequestDto>();
			MessagesRequestDto message = new MessagesRequestDto();
			message.setTo(recipientPhoneNumber);
			message.setContent(content);
			messages.add(message);
			smsRequestDto.setMessages(messages);
			
			String jsonBody = objectMapper.writeValueAsString(smsRequestDto); 
			HttpHeaders headers = new HttpHeaders(); 
			headers.set("Content-Type","application/json; charset=utf-8" );
			headers.set("x-ncp-apigw-timestamp", time.toString()); 
			headers.set("x-ncp-iam-access-key", "wKDBuFGJQ7Fn94C53HLw"); 
			String sig = makeSignature(time); 
			headers.set("x-ncp-apigw-signature-v2", sig); 
			HttpEntity<String> body = new HttpEntity<String>(jsonBody, headers); 
			RestTemplate restTemplate = new RestTemplate(); 
			sendSmsResponseDto = restTemplate.postForObject(new URI("https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:262568297465:team-project/messages"), body, SendSmsResponseDto.class); 
		} catch(Exception e) {
			
		}
		return sendSmsResponseDto; 
		} 
	private String makeSignature(Long time) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException { 
		String space = " "; // one space 
		String newLine = "\n"; // new line 
		String method = "POST"; // method 
		String url = "/sms/v2/services/ncp:sms:kr:262568297465:team-project/messages"; // url (include query string) 
		String timestamp = time.toString(); // current timestamp (epoch) 
		String accessKey = "wKDBuFGJQ7Fn94C53HLw"; // access key id (from portal or Sub Account) 
		String secretKey = "8MBbMGITUNikr5OwtrPKle7Uy2H8Qy3bsJWcx89Y"; 
		String message = new StringBuilder().append(method).append(space).append(url).append(newLine).append(timestamp).append(newLine).append(accessKey).toString(); 
		SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256"); 
		Mac mac = Mac.getInstance("HmacSHA256"); 
		mac.init(signingKey); 
		byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8")); 
		String encodeBase64String = Base64.encodeBase64String(rawHmac); 
		return encodeBase64String; 
	}
	public String rand() {
		Random ran = new Random();
		String str = "";
		int num;
		while(str.length() != 6) {
			num = ran.nextInt(10);
			str += num;
		}
		return str;
	}
}
