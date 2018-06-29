package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

//You can also download zipkin executable from https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec

@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZipkinServerApp.class, args);
	}

}
