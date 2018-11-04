package org.richardliao.job.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("org.richardliao.job.manager.db")
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
	return "job-manager";
    }

    @Override
    public MongoClient mongoClient() {
	return new MongoClient();
    }
}
