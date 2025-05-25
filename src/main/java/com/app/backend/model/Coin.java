package com.app.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coin {
    @Id
    String id;
    @Field("symbol")
    String symbol;
    String priceChange;
    Double priceChangePercent;
    String weightedAvgPrice;
    String prevClosePrice;
    Double lastPrice;
    String lastQty;
    String bidPrice;
    String bidQty;
    String askPrice;
    String askQty;
    String openPrice;
    String highPrice;
    String lowPrice;
    String volume;
    String quoteVolume;
    long openTime;
    long closeTime;
    int firstId;
    int lastId;
    int count;
}
