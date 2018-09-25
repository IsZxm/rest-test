package com.publicismedia;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTestApplicationTests {

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void testRest() {
		String url = "https://api.baidu.com/json/sms/service/AccountService/getAccountInfo ";
		String token = "bd0598ebfc5c61fef4d173cd2b03d103";
		String userName = "baidu-美赞臣2104339";
		String password = "MJN26840account";

		String[] params = {"baidu-美赞臣2104339"};
		MultiValueMap<String, String[]> requestBody = new LinkedMultiValueMap<>();
		requestBody.add("accountFields", params);

		HttpHeaders headers = new HttpHeaders();
		headers.add("token", token);
		headers.add("username", userName);
		headers.add("password", password);

		HttpEntity<MultiValueMap> requestEntity = new HttpEntity<MultiValueMap>(requestBody, headers);

		ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, requestEntity, JSONObject.class);
		System.out.println(responseEntity.toString());
		System.out.println(responseEntity.getBody());

	}
}
