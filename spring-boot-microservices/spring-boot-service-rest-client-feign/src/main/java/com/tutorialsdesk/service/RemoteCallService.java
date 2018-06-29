package com.tutorialsdesk.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="SERVICE-1")
public interface RemoteCallService {
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String getData();
}
