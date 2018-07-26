package com.tutorialsdesk.route;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.consul.ConsulConfiguration;
import org.apache.camel.component.jackson.JacksonDataFormat;
//import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.cloud.ServiceCallConfigurationDefinition;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteGateway extends RouteBuilder {

	@Autowired
	CamelContext context;
	
	 @Override
     public void configure() throws Exception {
         rest("/serviceCall")
             .get("/{serviceId}")
             .to("direct:service-call");

         from("direct:service-call")
             .setBody().constant(null)
             .removeHeaders("CamelHttp*")
             .to("log:service-call?level=INFO&showAll=true&multiline=true")
             .choice()
                 .when(header("serviceId").isEqualTo("service-1"))
                 	.to("http://localhost:8081/")
                     //.serviceCall("service-1")
                     .convertBodyTo(String.class)
                     .log("service-1 : ${body}")
                 .when(header("serviceId").isEqualTo("service-2"))
                 	.removeHeaders("CamelHttp*")	
                     .serviceCall("service-2")
                     .removeHeaders("CamelHttp*")
                     .convertBodyTo(String.class)
                     .log("service-2 : ${body}");
     }
}
