package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticSearchApp {

    public static void main(String args[]) {
        SpringApplication.run(ElasticSearchApp.class, args);
        //http://localhost:9200/books_index/books/_search?pretty=true
        //http://localhost:9200/books_index/books/_search?q=_id:1003&pretty=true
    }

}
