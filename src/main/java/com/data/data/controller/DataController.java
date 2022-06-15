package com.data.data.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	
	@GetMapping("/data")
	public String data() {
		// 인증키 (개인이 받아와야함)
    	String key = "545a6669736e616a373875484f6377";

    	// 파싱한 데이터를 저장할 변수
    	String result = "";

    	try {

    		URL url = new URL("http://openapi.seoul.go.kr:8088/"
    				+ key + "/json/bikeList/1/5/");

    		BufferedReader bf;

    		bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

    		result = bf.readLine();
    		System.out.println(result);

    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return result;
	}
	
	
}
