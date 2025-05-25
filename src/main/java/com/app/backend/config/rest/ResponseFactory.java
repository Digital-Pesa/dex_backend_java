package com.app.backend.config.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseFactory{

    public static ResponseEntity<?> clone(Object data){
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "OK");
        body.put("success", true);
        body.put("data", data);
        return new ResponseEntity<>(body,HttpStatus.OK);
    }

}
