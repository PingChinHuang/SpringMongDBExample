package com.superod.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "first_db";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("192.168.15.105");
	}

}
