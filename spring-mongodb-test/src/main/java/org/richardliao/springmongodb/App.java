package org.richardliao.springmongodb;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.Mongo;

import org.springframework.stereotype.Component;

import org.richardliao.springmongodb.repo.UserRepo;

/**
 * Hello world!
 *
 */
public class App
{
    
    public static void main( String[] args )
    {
	//App app = new App();
	//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mongodb.xml");
	ApplicationContext context = new AnnotationConfigApplicationContext(UserMongoConfig.class);
        //app.setMongoTemplate((MongoTemplate) context.getBean(MongoTemplate.class));
        UserOperation uo = (UserOperation)context.getBean(UserOperation.class);
        System.out.println( "Spring MongoDB Test..." );
	User user = new User();
	user.setName("Richard Liao " + new Date());
	user.setAge(30);
        uo.insert(user);
	//UserRepo repo = (UserRepo)context.getBean("userRepo");
	System.out.println(uo.findAll());
    }

    @Configuration
    @ComponentScan
    public static class UserMongoConfig {}

    @Component
    public static class UserOperation {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private UserRepo repo;

	public void insert(User user) {
	    System.out.println( "MongoTemplate: " + mongoTemplate);
	    mongoTemplate.insert(user);
	}

	public List<User> findAll() {
	    return repo.findAll();
	}
    }

    @Configuration
    @EnableMongoRepositories("org.richardliao.springmongodb.repo")
    public static class SpringMongoConfig extends AbstractMongoConfiguration {
	@Override
	public @Bean Mongo mongo() throws Exception {
	    return new Mongo("localhost");
	}
	
	@Override
	public @Bean MongoTemplate mongoTemplate() throws Exception {
	    return new MongoTemplate(mongo(),"test");
	}

	@Override
	public String getDatabaseName() {
	    return "test1";
	}
    }
}
