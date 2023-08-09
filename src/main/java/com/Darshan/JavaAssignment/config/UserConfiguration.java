package com.Darshan.JavaAssignment.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfiguration {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		
		return builder.build();
	}
	
	@Bean
	 public HttpHeaders customHttpHeaders() {
			return new HttpHeaders();
        
    }
	
//	  @Bean
//	    public HttpEntity<String> customHttpEntity(String body) {
//	        HttpHeaders headers = new HttpHeaders();
//	        return new HttpEntity<>(body, headers);
//	  }

}
