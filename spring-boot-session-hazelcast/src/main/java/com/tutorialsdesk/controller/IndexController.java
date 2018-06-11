package com.tutorialsdesk.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	HttpSession httpSession;

	@GetMapping("/index")
	public String indexPage() {

		Integer hits = (Integer) httpSession.getAttribute("hits");

		LOGGER.info("index() called, hits was '{}', session id '{}'", hits, httpSession.getId());

		if (hits == null) {
			hits = 0;
		}

		httpSession.setAttribute("hits", ++hits);

		return "index";
	}
}
