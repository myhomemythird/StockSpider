package org.richardliao.job.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories("org.richardliao.job.manager.db")
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    public @Bean Mongo mongo() throws Exception {
	return new Mongo("localhost");
    }
    
    @Override
    public @Bean MongoTemplate mongoTemplate() throws Exception {
	return new MongoTemplate(mongo(),"job-manager");
    }
    
    @Override
    public String getDatabaseName() {
	return "test1job-manager";
    }
}
