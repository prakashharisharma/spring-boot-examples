package com.tutorialsdesk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    HttpSession httpSession;

   @RequestMapping("/home")
   public String getHome(){
       return "home";
   }

    @GetMapping("/index")
    public String indexPage(){

        Integer hits = (Integer)httpSession.getAttribute("hits");

        LOGGER.info("index() called, hits was '{}', session id '{}'", hits, httpSession.getId());

        if (hits==null){
            hits = 0;
        }

        httpSession.setAttribute("hits",++hits);

        return "index";
    }
}
