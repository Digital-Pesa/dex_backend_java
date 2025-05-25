package com.app.backend.repository;


import com.app.backend.model.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CoinRepository extends MongoRepository<Coin,String> {
    List<Coin> findAllBySymbol(String symbol);
    Boolean existsCoinBySymbol(String symbol);
}
