package com.mycompany.web.mvc.model;

import java.math.BigDecimal;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class Exchange {

    public double getExchangePrice(String symbol, int money) {
        double exchangePrice = getExchangeBySymbol(symbol) * money;
        return exchangePrice;
    }
    
    public double getExchangeBySymbol(String symbol) {
        double exchange = 0;
        try {
            Stock stock = YahooFinance.get(symbol);
            BigDecimal price = stock.getQuote().getPrice();    
            exchange = price.doubleValue();
        } catch (Exception e) {
        }
        return exchange;
    }
}
