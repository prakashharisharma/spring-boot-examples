package com.tutorialsdesk.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@TestConfiguration
@Profile("test")
@EnableElasticsearchRepositories(basePackages = "com.tutorialsdesk.repository")
public class TestElasticSearchConfig {
    //Embedded Elasticsearch Server
   /* @Bean
    @Primary
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(nodeBuilder().local(true).node().client());
    }*/
}
