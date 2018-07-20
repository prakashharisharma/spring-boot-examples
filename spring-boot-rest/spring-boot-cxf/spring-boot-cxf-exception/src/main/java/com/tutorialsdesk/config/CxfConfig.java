package com.tutorialsdesk.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.tutorialsdesk.endpoint.StudentEndpoint;
import com.tutorialsdesk.exception.MissingStudentException;

@Configuration
public class CxfConfig{

	@Autowired
    private Bus bus;

    @Bean
    public Server rsServer() {
    	
    	List providers = new ArrayList();
        providers.add(getJacksonJsonProvider());
        providers.add(getMissingStudentException());
    	
        final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setProvider(new JacksonJsonProvider());
        endpoint.setBus(bus);
        endpoint.setAddress("/");
        endpoint.setServiceBeans(Arrays.<Object>asList(studentEndpoint()));
        endpoint.setProviders(providers);
        
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        
        return endpoint.create();
    }

    @Bean
    public StudentEndpoint studentEndpoint() {
        return new StudentEndpoint();
    }
    
    @Bean
    public JacksonJsonProvider getJacksonJsonProvider() {
        return new JacksonJsonProvider();
    }
     
    @Bean
    public MissingStudentException getMissingStudentException() {
        return new MissingStudentException();
    }

    // The default address of CXF RESTfull API is /services to change the API
    // sub-directory from /services with /api or anything that you like
    @Bean
    public ServletRegistrationBean cxfServlet() {
        final ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(new CXFServlet(), "/api/*");
        servletRegistrationBean.setLoadOnStartup(1);
       return servletRegistrationBean;
    }
    
}
