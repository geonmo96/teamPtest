package com.care.root.member.service;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@Service
public class NaverSmsServiceImpl {
	public int sendMessage(String phoneNumber, String content) {
		//JSONObject jsonObject = new JSONObject();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", "SMS");
		map.put("contentType", "COMM");
		map.put("countryCode", "82");
		map.put("from", phoneNumber);
		map.put("content", content);
		String jsonBody = null;
		try {
			jsonBody = new ObjectMapper().writeValueAsString(map);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String time = Long.toString(System.currentTimeMillis());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-ncp-apigw-timestamp", time);
		headers.set("x-ncp-iam-access-key", "wKDBuFGJQ7Fn94C53HLw");
		headers.set("x-ncp-apigw-signature-v2", makeSignature(time));
		
		HttpEntity<String> body = new HttpEntity<String>(jsonBody, headers);
		System.out.println(body.getHeaders());
		System.out.println(body.getBody());
		
		//RestTemplate restTemplate = new RestTemplate();
		//restTemplate.postForObject(new URL("https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:262568297465:team-project/messages"), body);
		URL url = null;
		int responseCode = 0;
		try {
			url = new URL("https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:262568297465:team-project/messages");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
			bw.write(body.getBody().toString());
			bw.flush();
			
			responseCode = urlConnection.getResponseCode();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(responseCode);
		return responseCode;
	}
	
	public String makeSignature(String time) {
		String encodeBase64String = null;
			try {
			   String space = " ";               // one space
			   String newLine = "\n";               // new line
			   String method = "GET";               // method
			   String url = "/sms/v2/services/ncp:sms:kr:262568297465:team-project/messages";   // url (include query string)
			   String timestamp = time;       // current timestamp (epoch)
			   String accessKey = "wKDBuFGJQ7Fn94C53HLw";         // access key id (from portal or Sub Account)
			   String secretKey = "8MBbMGITUNikr5OwtrPKle7Uy2H8Qy3bsJWcx89Y";
	
			   String message = new StringBuilder()
			      .append(method)
			      .append(space)
			      .append(url)
			      .append(newLine)
			      .append(timestamp)
			      .append(newLine)
			      .append(accessKey)
			      .toString();
	
			   SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
			   Mac mac = Mac.getInstance("HmacSHA256");
			   mac.init(signingKey);
	
			   byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
			   encodeBase64String = Base64.encodeBase64String(rawHmac);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return encodeBase64String;
	}
}
