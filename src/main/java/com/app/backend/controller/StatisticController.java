package com.app.backend.controller;

import com.app.backend.config.rest.ResponseFactory;
import com.app.backend.model.Commission;
import com.app.backend.model.Fee;
import com.app.backend.model.Wallet;
import com.app.backend.repository.CommissionRepository;
import com.app.backend.repository.FeeRepository;
import com.app.backend.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class StatisticController {
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    CommissionRepository commissionRepository;

    @PostMapping("/private/statistic/get")
    ResponseEntity getStatistic() {
        Instant current = Instant.now();
        List<Wallet> daily = this.walletRepository.findAllByCreatedAtBetween(current.minus(1, ChronoUnit.DAYS), current.plus(1, ChronoUnit.DAYS));
        List<Wallet> weekly = this.walletRepository.findAllByCreatedAtBetween(current.minus(6, ChronoUnit.DAYS), current);
        HashMap map = new HashMap();
        HashMap wallet = new HashMap();
        wallet.put("daily", daily);
        wallet.put("weekly", weekly);
        map.put("wallet", wallet);
        List<Commission> commissionsDaily = this.commissionRepository.findAllByCreatedAtBetween(current.minus(1, ChronoUnit.DAYS), current.plus(1, ChronoUnit.DAYS));
        List<Commission> commissionsWeekly = this.commissionRepository.findAllByCreatedAtBetween(current.minus(6, ChronoUnit.DAYS), current);
        HashMap commission = new HashMap();
        commission.put("daily", commissionsDaily);
        commission.put("weekly", commissionsWeekly);
        map.put("commission", commission);
        return ResponseFactory.clone(map);
    }

}
