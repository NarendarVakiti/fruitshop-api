package com.fruitshop.repository;

import com.fruitshop.bean.Fruits;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitsRepository extends MongoRepository<Fruits, Integer> {

    //@Query
    //public Fruits findFruitByName(String fruit);
}
