package com.app.backend.repository;

import com.app.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    public User findByUsername(String username);
}
