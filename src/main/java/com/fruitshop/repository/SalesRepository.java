package com.fruitshop.repository;

import com.fruitshop.bean.Sales;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesRepository extends MongoRepository<Sales, Integer> {
}
