package com.app.backend.controller;

import com.app.backend.config.rest.ResponseFactory;
import com.app.backend.model.Commission;
import com.app.backend.model.Fee;
import com.app.backend.repository.CommissionRepository;
import com.app.backend.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommissionController {
    @Autowired
    CommissionRepository commissionRepository;
    @PostMapping("/private/commission/save")
    ResponseEntity save(@RequestBody Commission commission){
        return ResponseFactory.clone(commissionRepository.save(commission));
    }
}
