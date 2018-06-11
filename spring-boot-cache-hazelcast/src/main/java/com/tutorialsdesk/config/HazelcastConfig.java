package com.tutorialsdesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@Profile("dev")
public class HazelcastConfig {

	@Bean
    public HazelcastInstance config() {

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getGroupConfig().setName("jet").setPassword("jet-pass");
        clientConfig.getNetworkConfig().addAddress("127.0.0.1:5701");
        return HazelcastClient.newHazelcastClient(clientConfig);

    }

}
