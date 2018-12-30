package org.richardliao.springmongodb.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.richardliao.springmongodb.User;

public interface UserRepo extends MongoRepository<User, String> {
}
