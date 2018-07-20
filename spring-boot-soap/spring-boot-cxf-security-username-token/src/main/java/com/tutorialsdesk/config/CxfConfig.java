package com.tutorialsdesk.config;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.cxf.ws.security.SecurityConstants;
import org.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tutorialsdesk.service.impl.GreetingServiceImpl;
import com.tutorialsdesk.service.impl.InfoServiceImpl;
import com.tutorialsdesk.service.interceptors.AppInboundInterceptor;
import com.tutorialsdesk.service.interceptors.AppOutboundInterceptor;
import com.tutorialsdesk.service.interceptors.CustomUsernameTokenValidator;
import com.tutorialsdesk.service.interceptors.UTPasswordCallback;

@Configuration
public class CxfConfig {

	@Bean
	public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }
	
    @Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {   
    	
    	SpringBus springBus = new SpringBus();
       	springBus.getInInterceptors().add(new AppInboundInterceptor());
    	springBus.getOutInterceptors().add(new AppOutboundInterceptor());
    	
    	return springBus;
    }	
    
    @Bean
    public UTPasswordCallback myPasswordCallback() {
        
        return new UTPasswordCallback();
    }
    
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new InfoServiceImpl());
        endpoint.getFeatures().add(new LoggingFeature());

        PolicyBasedWSS4JInInterceptor pwssIn = new PolicyBasedWSS4JInInterceptor();
        
        endpoint.getInInterceptors().add(pwssIn);

        Map<String, Object> inProps = new HashMap<>();
        inProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        inProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
        WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
        
        endpoint.getInInterceptors().add(wssIn);

        endpoint.getProperties().put(SecurityConstants.USERNAME_TOKEN_VALIDATOR, CustomUsernameTokenValidator.class.getName());

        
        endpoint.publish("/InfoService");
        
        return endpoint;
    }
    
    @Bean
    public Endpoint greetingEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new GreetingServiceImpl());
        endpoint.getFeatures().add(new LoggingFeature());
        
        
       
        Map<String, Object> inProps = new HashMap<>();
        
        inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
        inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
         
        WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
        
        endpoint.getInInterceptors().add(wssIn);
       
        
        endpoint.publish("/GreetingService");
        
        
      
        
        return endpoint;
    }
}