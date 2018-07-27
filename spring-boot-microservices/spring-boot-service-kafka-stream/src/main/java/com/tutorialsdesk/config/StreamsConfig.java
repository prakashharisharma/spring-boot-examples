package com.tutorialsdesk.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.tutorialsdesk.stream.GreetingsStreams;


@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}
