package com.tutorialsdesk;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JerseyAppTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/students-api/students",
				String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void reverse() {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("/students-api/students/1", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}

	@Test
	public void validation() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/students-api/some_random_uri",
				String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void actuatorStatus() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/health",
				String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).isEqualTo("{\"status\":\"UP\"}");
	}
}
