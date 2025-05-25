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
public class Commission {
    @Id
    private String id;
    private String address;
    private Double rate;
    private Double amount;
    private Date createdAt = new Date();
}
