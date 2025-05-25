package com.app.backend.repository;

import com.app.backend.model.Commission;
import com.app.backend.model.Fee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public interface CommissionRepository extends MongoRepository<Commission,String> {
    public List<Commission> findAllByCreatedAtBetween(Instant from,Instant to);
}
