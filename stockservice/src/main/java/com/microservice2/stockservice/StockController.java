package com.microservice2.stockservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/{id}")
    public int getNumberOnStock(@PathVariable("id") int productNumber){
        System.out.println("In Stock Service");
        return stockService.getNumberOnStock(productNumber);
    }
}
