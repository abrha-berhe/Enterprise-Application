package com.microservice2.stockservice;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class StockService {
    private Map<Integer, Integer> stockRepository;

    StockService(){
        stockRepository = new HashMap<>();
        stockRepository.put(1,10);
        stockRepository.put(2,20);
        stockRepository.put(3,30);
        stockRepository.put(4,40);
    }

    public int getNumberOnStock(int productNumber){
        return stockRepository.get(productNumber);
    }
}
