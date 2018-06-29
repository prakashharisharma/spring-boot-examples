package com.tutorialsdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorialsdesk.service.ExternalUrlService;
import com.tutorialsdesk.service.RemoteCallService;

@RestController
public class HelloController {

	@Autowired
	private RemoteCallService remoteCallService;
	
	@Autowired
	private ExternalUrlService externalUrlService;
	
	@GetMapping("/")
	public String echoTheUsersEmailAddress() {
	   return remoteCallService.getData();
	}
	
	/*@GetMapping("/posts/{postId}")
	public String callExternalUrl(@PathVariable("postId") String postId ) {
		System.out.println("Path Variable " + postId);
	   return externalUrlService.getPostById(postId);
	}*/
	
	@GetMapping("/posts/")
	public String callExternalUrl() {
	   return externalUrlService.getPosts();
	}
}
