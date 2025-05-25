package com.app.backend.repository;

import com.app.backend.model.Fee;
import com.app.backend.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface FeeRepository extends MongoRepository<Fee,String> {
    public List<Fee> findAllByCreatedAt(Date date);
    public List<Fee> findAllByCreatedAtBeforeAndCreatedAtAfter(Date before,Date after);
}
