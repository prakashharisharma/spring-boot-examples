package com.tutorialsdesk.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;



@Configuration
@EnableElasticsearchRepositories(basePackages = "com.tutorialsdesk.repository")
public class ElasticSearchConfig {

    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;


@Bean
public Client client() throws UnknownHostException {
    Settings elasticsearchSettings = Settings.builder()
      .put("client.transport.sniff", true)
      //.put("path.home", elasticsearchHome)
      .put("cluster.name", EsClusterName).build();
    TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
    client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    return client;
}

/*@Bean
public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
    return new ElasticsearchTemplate(client());
}
*/
}
