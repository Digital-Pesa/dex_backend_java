package com.app.backend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BalanceDto {
    private String walletAddress;
    private Double totalBalance;
    private String chain;
}
