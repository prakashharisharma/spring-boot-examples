package com.tutorialsdesk.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder{
	

	@Override
	public void configure() throws Exception {
		
		//copy all the files from inputFolder to outputFolder
		from("file:D://inputFolder?noop=true").to("file:D://outputFolder");
		
		 // here is a sample which processes the input files
	    // (leaving them in place - see the 'noop' flag)
	    // then performs content based routing on the message using XPath
		
		from("file:src/inputFolder?noop=true")
        .choice()
            .when(xpath("/person/city = 'London'"))
                .to("file:target/messages/uk")
                .to("log:UK Message")
            .otherwise()
                .to("file:target/messages/others")
                .to("log:Others Message");
		
		from("direct:start")
		.setHeader(Exchange.HTTP_METHOD,constant(HttpMethods.POST))
		  .to("http4://www.google.com");
		
	}
}
