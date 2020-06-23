package com.fruitshop.repository;

import com.fruitshop.bean.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OwnerRepository extends MongoRepository<Owner, Integer> {
}
