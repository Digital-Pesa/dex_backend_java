package com.app.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
@CompoundIndexes(value = {
        @CompoundIndex(name = "aid_bid_idx", def = "{'symbol' : 1, 'deviceId' : 1}", unique = true)})
public class Device {
    @Id
    String id;
    String deviceId;
    String symbol;
    boolean enabled = true;
}
