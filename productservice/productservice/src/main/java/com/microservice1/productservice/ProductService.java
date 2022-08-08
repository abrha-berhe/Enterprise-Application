package com.microservice1.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productsDatabase;
    @Autowired
    private ProductFeignClientProxy productFeignClientProxy;

    ProductService(){
        productsDatabase = Arrays.asList(
                new Product(1,"Laptop",0),
                new Product(2,"Iphone",0),
                new Product(3,"Monitor",0),
                new Product(4,"Printer",0)
        );
    }
    public Product getProduct(long id) {
        Product product = productsDatabase.stream().filter(p->p.getProductNumber()==id).findFirst().get();
        int numberOnStock = productFeignClientProxy.getNumberOnStock(id);
        product.setNumberOnStock(numberOnStock);
        return product;
    }
}
