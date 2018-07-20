package com.tutorialsdesk.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.springframework.hateoas.core.AnnotationRelProvider;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.hateoas.hal.Jackson2HalModule.HalHandlerInstantiator;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper = new ObjectMapper();

    public JacksonContextResolver() {
        mapper.registerModule(new Jackson2HalModule());
        mapper.setHandlerInstantiator(new HalHandlerInstantiator(
                new AnnotationRelProvider(), null, null));
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}