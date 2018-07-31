package com.tutorialsdesk;

import java.net.URI;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class SpringRESTClient {

	public static void main(String[] args) {
		SpringRESTClient src = new SpringRESTClient();

		src.testGetFOrObject();
		src.testExchange();
	}

	public void testGetFOrObject() {

		// uri = "http://localhost:8080/students/1";

		int empId = 1;
		URI uri = UriComponentsBuilder.newInstance().scheme("http").host("localhost").port(8080).path("students").path("/{rollNumber}").buildAndExpand(empId).toUri();

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		
		System.out.println(result);
	}

	public void testExchange() {
		// uri = "http://localhost:8080/students/1";
		int empId = 1;
		URI uri = UriComponentsBuilder.
				newInstance()
				.scheme("http")
				.host("localhost")
				.port(8080)
				.path("students")
				.path("/{rollNumber}")
				.buildAndExpand(empId).toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
}
