package com.fruitshop.service;

import com.fruitshop.bean.Fruits;
import com.fruitshop.repository.FruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FruitsServiceImpl implements FruitsService {

    private final MongoTemplate mongoTemplate;

    public FruitsServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @Autowired
    private FruitsRepository fruitsRepository;

    @Override
    public Fruits addFruit(Fruits fruit) {
        Fruits response = new Fruits();
        try{
            response = fruitsRepository.save(fruit);
        }catch(Exception e){
            throw e;
        }
        return response;
    }

    @Override
    public List<Fruits> getFruitsDetails() {
        List<Fruits> fruitsList = new ArrayList<>();
        try{
            fruitsList = fruitsRepository.findAll();
        }catch(Exception e){
            throw e;
        }
        return fruitsList;
    }

    @Override
    public Fruits findFruitByName(String fruitName) {
        Fruits fruit = new Fruits();
        try{
            Query query = new Query().addCriteria(Criteria.where("fruitName").is(fruitName));
            fruit = (Fruits) mongoTemplate.find(query, Fruits.class);
           // fruit = fruitsRepository.findFruitByName(fruitName);
        }catch(Exception e){
            throw e;
        }
        return fruit;
    }
}
