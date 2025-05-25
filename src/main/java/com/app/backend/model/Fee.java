package com.app.backend.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fee {
    @Id
    private String id;
    private String btcAddress;
    private String ethAddress;
    private String tronAddress;

    private Double rate;
    private Date createdAt = new Date();
}
