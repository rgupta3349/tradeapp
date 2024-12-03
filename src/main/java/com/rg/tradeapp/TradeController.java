package com.rg.tradeapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TradeController {

    @Autowired
    private StockTradeRepository repository;

    @GetMapping(path = "/trades")
    public List<StockTrade> getTrades() {

        // StockTrade trade = new StockTrade();

        // trade.setType("sell");
        // trade.setUserId(23);
        // trade.setSymbol("ABC");

        // trade.setShares(30);
        // trade.setPrice(142);
        // trade.setTimestamp(155555555L);
        // repository.save(trade);

        // repository.save(new StockTrade("sell", 23, "ABC", 30, 142, (long) 15555555));
        System.out.println(repository.findAll());

        return repository.findAll();

        // return new StockTrade(1, "buy", 23, "ABC", 30, 142, (long) 15555555);

    }

    @GetMapping(path = "/trade/{id}")
    public StockTrade getTrade(@PathVariable Integer id) {

        System.out.println(id);
        Optional<StockTrade> optionalStockTrade = repository.findById(id);
        return optionalStockTrade.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        // return ResponseEntity.ok(repository.findAll());

        // return repository.findById(id);

    }

    @PostMapping(path = "/trades")
    public List<StockTrade> postTrade(@RequestBody StockTrade requestBody) {
        StockTrade trade = new StockTrade();
        trade.setType(requestBody.getType());
        trade.setUserId(requestBody.getUserId());
        trade.setSymbol(requestBody.getSymbol());

        trade.setShares(requestBody.getShares());
        trade.setPrice(requestBody.getPrice());
        trade.setTimestamp(requestBody.getTimestamp());
        repository.save(trade);

        return getTrades();
    }

    @DeleteMapping(path = "/trades/{id}")
    public void deleteTrade(@PathVariable Integer id) {
        System.out.println(id);
        repository.deleteById(id);

    }

    @DeleteMapping(path = "/trades/softdelete/{id}")
    public void softDeleteTrade(@PathVariable Integer id) {
        System.out.println(id);
        Optional<StockTrade> optionalTrade = repository.findById(id);

        if (optionalTrade.isPresent()) {
            StockTrade trade = optionalTrade.get();
            trade.setDeleted("Yes");
            repository.save(trade);
        }

    }

}
