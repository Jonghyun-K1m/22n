package com.hyeon.dnf.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class dnfService {

	@Value("${mykey}")
	private String mykeyv;

	public void dnfSerivce() {
	}
	
	
	public JSONObject serverSearch() {
		log.debug("debug test");
		log.info("info test");
		log.warn("warn test");
		log.error("error test");
		 
		String request_url = "https://api.neople.co.kr/df/servers?apikey=";
		request_url=request_url+mykeyv;
		URL url;
		StringBuilder sb = new StringBuilder();
		String line = null;
		JSONObject jObject = null;
		try {
			url = new URL(request_url);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET"); // http 메서드
			conn.setRequestProperty("Content-Type", "application/json"); // header Content-Type 정보
			conn.setRequestProperty("auth", "myAuth"); // header의 auth 정보
			conn.setDoOutput(true); // 서버로부터 받는 값이 있다면 true
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

			
			while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
				sb.append(line);
			}
		    jObject = new JSONObject(sb.toString());

		    
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return jObject;
	}
}
