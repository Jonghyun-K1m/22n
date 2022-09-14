package jpabook.jpashop.Controller;


import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import org.json.*;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jpabook.jpashop.domain.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/naver")
public class LoginController {

    public static final String CLIENT_ID = "izxS7XQJDCPeYvHN5jeF";

    @GetMapping("/auth")
    public String authNaver(@RequestParam String code, @RequestParam String state, Model s) {
        String accessToken = extractAccessToken(requestAccessToken(generateAuthCodeRequest(code, state)).getBody());
        log.info(accessToken);
        String acc=requestProfile(generateProfileRequest(accessToken)).getBody();    
        return requestProfile(generateProfileRequest(accessToken)).getBody();
    }

    
   /*
    @GetMapping("/auth")
    public ResponseEntity<?> authNaver(@RequestParam String code, @RequestParam String state, Model s) {
        String accessToken = extractAccessToken(requestAccessToken(generateAuthCodeRequest(code, state)).getBody());
        log.info(accessToken);
        //JSON으로 받았음
        String acc=requestProfile(generateProfileRequest(accessToken)).getBody();
        
        //로직처리필요
//        Member ac= new Member();
//        ac.setName("did");
        String ad="SD";
        
        HttpHeaders hd =new HttpHeaders();
        hd.setLocation(URI.create("/"));
        
        //return new ResponseEntity<>(hd,HttpStatus.MOVED_PERMANENTLY);
        return new ResponseEntity<>(ad,hd,HttpStatus.MOVED_PERMANENTLY);
        
    }
*/

    private ResponseEntity<String> requestProfile(HttpEntity request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.POST,
                request,
                String.class
                
        );
       
    }
//    private String requestProfile(HttpEntity request) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> acc= restTemplate.exchange(
//                "https://openapi.naver.com/v1/nid/me",
//                HttpMethod.POST,
//                request,
//                String.class          );  
//        return "/";
//    }

    private HttpEntity<MultiValueMap<String, String>> generateProfileRequest(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+ accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        return new HttpEntity<>(headers);
    }

    private String extractAccessToken(String accessTokenResponse) {
        JSONObject jobj = new JSONObject(accessTokenResponse);
        log.info(accessTokenResponse);
        return jobj.getString("access_token");
    }


    private ResponseEntity<String> requestAccessToken(HttpEntity request) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                "https://nid.naver.com/oauth2.0/token",
                HttpMethod.POST,
                request,
                String.class
        );
    }

    private HttpEntity<MultiValueMap<String, String>> generateAuthCodeRequest(String code, String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", CLIENT_ID);
        params.add("client_secret", CLIENT_SECRET);
        params.add("redirect_uri", "http://localhost:8080");
        params.add("code", code);
        params.add("state", state);
        return new HttpEntity<>(params, headers);
    }
}