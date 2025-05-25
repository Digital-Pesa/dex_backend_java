package com.app.backend.repository;

import com.app.backend.model.Fee;
import com.app.backend.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public interface WalletRepository extends MongoRepository<Wallet, String> {
    public List<Wallet> findAllByCreatedAtBetween(Instant from, Instant to);
    public List<Wallet> findAllByCreatedAtBeforeAndCreatedAtAfter(Date before,Date after);
    public Wallet findByBtcAddressAndEthAddress(String btcAddress,String ethAddress);
    public Wallet findByEthAddress(String ethAddress);
    public Wallet findByTronAddress(String tronAddress);
}
