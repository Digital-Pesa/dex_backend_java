package com.app.backend.model;

import java.util.ArrayList;
import java.util.Date;


public class CoinGecko{
    public String id;
    public String symbol;
    public String name;
    public String image;
    public double current_price;
    public Long market_cap;
    public Long market_cap_rank;
    public Long fully_diluted_valuation;
    public Long total_volume;
    public double high_24h;
    public double low_24h;
    public double price_change_24h;
    public double price_change_percentage_24h;
    public double market_cap_change_24h;
    public double market_cap_change_percentage_24h;
    public double circulating_supply;
    public double total_supply;
    public Object max_supply;
    public double ath;
    public double ath_change_percentage;
    public Date ath_date;
    public double atl;
    public double atl_change_percentage;
    public Date atl_date;
    public Roi roi;
    public Date last_updated;
    public SparklineIn7d sparkline_in_7d;
}


