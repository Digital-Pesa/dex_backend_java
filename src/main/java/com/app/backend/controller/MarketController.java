package com.app.backend.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MarketController {
    @GetMapping("/market/gainersandlosers")
    String gainersAndLosers() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.binance.com/api/v3/ticker/24hr");
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);
    }
}
