package com.tutorialsdesk.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="externalService", url="https://jsonplaceholder.typicode.com")
public interface ExternalUrlService {

	//@RequestMapping(method=RequestMethod.GET, value="/posts/{postId}")
	//public String getPostById(@Param("postId") String postId);
	
	@RequestMapping(method=RequestMethod.GET, value="/posts/")
	public String getPosts();
	
}
