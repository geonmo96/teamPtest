package com.care.root.member.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dao.ExternalMemberDAO;
import com.care.root.member.dto.ExternalMemberDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class KakaoServiceImpl implements KakaoService{
	@Autowired ExternalMemberDAO edao;
	@Override
	public void login(String code, HttpServletRequest request) {
		String accessToken = getAccessToken(code);
		HashMap<String, Object> userInfo = getUserInfo(accessToken);
		HttpSession session = (HttpSession)request.getSession();
		session.setAttribute("USER", userInfo.get("nickName"));
		session.setAttribute("login", "kakao");
		int e_id = Integer.parseInt((String) userInfo.get("id"));
		ExternalMemberDTO eDto = edao.selectId(e_id);
		if(eDto == null) {
			ExternalMemberDTO dto = new ExternalMemberDTO();
			dto.setE_id(e_id);
			dto.setE_name((String)userInfo.get("nickName"));
			edao.join(dto);
			System.out.println("회원가입");
		}
	}
	
	private HashMap<String, Object> getUserInfo(String accessToken){
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		String requestUrl = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Authorization", "Bearer " + accessToken);
			int responseCode = urlConnection.getResponseCode();
			System.out.println("response code(info) : " + responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line = "";
			String result = "";
			while((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body(info) : " + result);
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			String nickName = properties.getAsJsonObject().get("nickname").getAsString();
			String id = element.getAsJsonObject().get("id").getAsString();
			userInfo.put("id", id);
			System.out.println("카카오 아이디 : " + id);
			userInfo.put("nickName", nickName);
			br.close();
		} catch(Exception e) {
			System.out.println("KakaoServiceImpl.getUserInfo() - 에러 발생");
			e.printStackTrace();
		}
		return userInfo;
	}
	
	private String getAccessToken(String code) {
		String accessToken = "";
		String requestUrl = "https://kauth.kakao.com/oauth/token";
		try {
			String sendMessage = "grant_type=authorization_code" 
		               + "&client_id=b7c160fc4b5f9830243927d9a94aea71"
		               +"&redirect_uri=http://localhost:8080/root/member/loginKakao" 
		               + "&code=" + code;
			URL url = new URL(requestUrl);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
			bw.write(sendMessage);
			bw.flush();
			
			int responseCode = urlConnection.getResponseCode();
			System.out.println("받은 코드 결과 (200:성공) : " + responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line = "";
			String result = "";
			while((line = br.readLine()) != null) {
				result += line;
			}
//			System.out.println("받은 메시지 : " + result);
//			System.out.println("스플릿 : " + result.split(","));
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			accessToken = element.getAsJsonObject().get("access_token").getAsString();
//			System.out.println("access token : " + accessToken);
			br.close();
			bw.close();
		} catch (Exception e) {
			System.out.println("토큰 받기 실패 KakaoServiceImpl.getAccessToken");
			e.printStackTrace();
		}
		return accessToken;
	}
}
