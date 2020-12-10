package com.care.root.member.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class NaverServiceImpl implements NaverService{
	
	public void generateState( HttpServletRequest request) {
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString(32);
	    HttpSession session = (HttpSession)request.getSession();
	    session.setAttribute("state", state);
	}
	
//	String requestURL = "http://api.openhangul.com/basic?q=";
//	URL originWordRequestURL = new URL(requestURL + URLEncoder.encode(paramValue, "UTF-8"));
	@Override
	
	public void login(String code, String state, HttpServletRequest request) {
		// 상태 토큰 일치 확인
		HttpSession session = (HttpSession) request.getSession();
		String storedState = (String)session.getAttribute("state");
		if(!storedState.equals(state)) {
			// 비정상적인 토큰
			return ;
		}
		String accessToken = getAccessToken(code, storedState);
		HashMap<String, Object> userInfo = getUserInfo(accessToken);
		session.setAttribute("USER", userInfo.get("name"));
	}
	
	private HashMap<String, Object> getUserInfo(String accessToken){
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		String requestUrl = "https://openapi.naver.com/v1/nid/me";
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Authorization", "Bearer " + accessToken);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			String line = "";
			String result = "";
			while((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println(result);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			JsonObject response = element.getAsJsonObject().get("response").getAsJsonObject();
			String name = response.getAsJsonObject().get("name").getAsString();
			userInfo.put("name", name);
			br.close();
		} catch(Exception e) {
			System.out.println("NaverServiceImpl.getUserInfo() - 에러");
			e.printStackTrace();
		}
		return userInfo;
	}
	
	private String getAccessToken(String code, String storedState) {
		String requestUrl = "https://nid.naver.com/oauth2.0/token";
		String accessToken = "";
		String sendMessage = 
				"client_id=0jF_bgnlPUqcPix8EEPa"
				+ "&client_secret=BiIZM5wfXD"
				+ "&grant_type=authorization_code"
				+ "&state=" + storedState
				+ "&code=" + code;
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
			bw.write(sendMessage);
			bw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line = "";
			String result = "";
			while((line = br.readLine()) != null) {
				result += line;
			}
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			accessToken = element.getAsJsonObject().get("access_token").getAsString();
			br.close();
			bw.close();
		} catch(Exception e) {
			System.out.println("NaverServiceImpl.login() - 에러 발생");
			e.printStackTrace();
		}
		return accessToken;
	}
}
