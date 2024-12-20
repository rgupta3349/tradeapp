package com.rg.tradeapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTradeRepository extends JpaRepository<StockTrade, Integer> {
}