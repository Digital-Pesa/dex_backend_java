package com.app.backend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Getter
@Setter
@Data
public class WalletDto {
    private String btcAddress;
    private String ethAddress;
    private String tronAddress;
    private Double balance;
    private Date createdAt = new Date();
    private String chain;
}
