package com.rg.tradeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TradeCommandLineRunner implements CommandLineRunner {

    @Autowired
    private StockTradeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("command line runner Rajan");

        StockTrade trade = new StockTrade();
        trade.setType("buy");
        trade.setUserId(23);
        trade.setSymbol("ABC");

        trade.setShares(30);
        trade.setPrice(142);
        trade.setTimestamp(155555555L);
        repository.save(trade);

        System.out.println(repository.findAll());
    }

}
