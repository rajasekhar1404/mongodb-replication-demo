package com.krs.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.master.uri}")
    private String masterUri;

    @Value("${spring.data.mongodb.slave.uri}")
    private String slaveUri;

    @Bean
    public MongoClient masterMongoClient() {
        return MongoClients.create(masterUri);
    }

    @Bean
    public MongoClient slaveMongoClient() {
        return MongoClients.create(slaveUri);
    }

    @Bean(name = "masterMongoTemplate")
    public MongoTemplate masterMongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(masterMongoClient(), "settings");
        return mongoTemplate;
    }

    @Bean(name = "slaveMongoTemplate")
    public MongoTemplate slaveMongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(slaveMongoClient(), "settings");
        return mongoTemplate;
    }
}
