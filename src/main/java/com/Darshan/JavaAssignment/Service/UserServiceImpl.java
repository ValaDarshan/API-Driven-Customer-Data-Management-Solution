package com.Darshan.JavaAssignment.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Darshan.JavaAssignment.Model.UserLogin;
import com.Darshan.JavaAssignment.Model.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Value("${external.api.url}")
	private String baseUrl;

	@Autowired
	HttpHeaders customHttpHeaders;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String getToken(UserLogin ul) {

		String msg;

		HttpEntity<UserLogin> customHttpEntity = new HttpEntity<>(ul);
		ResponseEntity<String> res = restTemplate.postForEntity(baseUrl, customHttpEntity, String.class);

		if (res.getStatusCode() == HttpStatus.OK) {
			String token = res.getBody();
			int startIndex = token.indexOf(":\"") + 2;
			int endIndex = token.indexOf("\"", startIndex);
			msg = "Bearer " + token.substring(startIndex, endIndex);

		} else {
			msg = "error";
		}

		return msg;

	}

	@Override
	public List<Users> getUsers(HttpSession session) {

		customHttpHeaders.set("Authorization", (String) session.getAttribute("token"));
		HttpEntity<Object> entity = new HttpEntity<Object>(customHttpHeaders);
		ResponseEntity<Users[]> response = restTemplate.exchange(
				"https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list", HttpMethod.GET,
				entity, Users[].class);
		Users[] user = response.getBody();
		
//		System.out.println(user)

		return Arrays.asList(user);
	}

	@Override
	public String createUser(Users user, HttpSession session) {
		String result = null;
		customHttpHeaders.set("Authorization", (String) session.getAttribute("token"));
		HttpEntity<Users> he = new HttpEntity<>(user, customHttpHeaders);
		ResponseEntity<String> res = restTemplate.postForEntity("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=create", he, String.class);
		System.out.println(res.getStatusCode());
		if(res.getStatusCode() == HttpStatus.CREATED) {
			result = "created";
		}
		else {
			result = "error";
		}
		
		return result;
	}

	@Override
	public String deleteUser(String uuid, HttpSession session) {
		
		String result = null;
		
		customHttpHeaders.set("Authorization", (String) session.getAttribute("token"));
		HttpEntity<String> he = new HttpEntity<>("", customHttpHeaders);
		
		ResponseEntity<String> res = restTemplate.postForEntity("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=delete&uuid="+uuid, he,String.class);
		if(res.getStatusCode() == HttpStatus.OK) {
			result = "deleted";
		}
		
		return result;
	}

	@Override
	public String updateUser(String uuid, Users user, HttpSession session) {
		
		String result = null;
		
		customHttpHeaders.set("Authorization", (String) session.getAttribute("token"));
		HttpEntity<Users> he = new HttpEntity<>(user, customHttpHeaders);
		ResponseEntity<String> res = restTemplate.postForEntity("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=update&uuid="+uuid, he, String.class);
		System.out.println(res);
		if(res.getStatusCode() == HttpStatus.OK) {
			result = "success";
		}
		
		return result;
	}

}
