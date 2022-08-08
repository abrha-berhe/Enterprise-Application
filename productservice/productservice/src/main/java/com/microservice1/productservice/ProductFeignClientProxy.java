package com.microservice1.productservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-service", url = "http://localhost:8900/")
public interface ProductFeignClientProxy {
    @GetMapping("stock/{productNumber}")
    public int getNumberOnStock(@PathVariable("productNumber") long productNumber);
}
