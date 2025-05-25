package com.app.backend.controller;

import com.app.backend.config.rest.ResponseFactory;
import com.app.backend.model.Fee;
import com.app.backend.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeeController {
    @Autowired
    FeeRepository feeRepository;
    @PostMapping("/fee/get")
    ResponseEntity getFee(){
        return ResponseFactory.clone(feeRepository.findAll().get(0));
    }
    @PostMapping("/fee/delete")
    ResponseEntity deleteFee(@RequestParam("id")String id){
        feeRepository.deleteById(id);
        return ResponseFactory.clone("");
    }
    @PostMapping("/private/fee/save")
    ResponseEntity saveFee(@RequestBody Fee fee){
        return ResponseFactory.clone(feeRepository.save(fee));
    }
}
