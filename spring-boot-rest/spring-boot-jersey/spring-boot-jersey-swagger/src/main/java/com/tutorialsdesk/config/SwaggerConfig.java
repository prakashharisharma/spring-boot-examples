package com.tutorialsdesk.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:8080/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.tutorialsdesk.endpoint")).paths(PathSelectors.any())
				.build().enable(true).apiInfo(apiInfo());
	}

	public ApiInfo apiInfo() {
		StringVendorExtension vendorExtension = new StringVendorExtension("", "");
		Collection<VendorExtension> vendorExtensions = new ArrayList<>();
		vendorExtensions.add(vendorExtension);

		Contact contactInfo = new Contact("AtechRef", "www.atechref.com", "atechsoft@gmail.com");

		return new ApiInfo("SpringBoot-Swagger2-JaxRS",
				"Example project showing how to integrate spring boot "
						+ "web app using jaxrs instead of springmvc with swagger and springfox.",
				"1.0", "For Demo only", contactInfo, "Apache 2.0", "www.apache.org", vendorExtensions);
	}
}
