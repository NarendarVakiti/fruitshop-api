package com.fruitshop.service;

import com.fruitshop.bean.CustomerRequest;
import com.fruitshop.bean.Fruits;
import com.fruitshop.bean.FruitsRequest;
import com.fruitshop.bean.Sales;
import com.fruitshop.repository.FruitsRepository;
import com.fruitshop.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    private final MongoTemplate mongoTemplate;

    public SalesServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private FruitsRepository fruitsRepository;

    @Autowired
    private FruitsService fruitsService;


    @Override
    public Sales takeCustomerRequest(CustomerRequest customerRequest) {

        List<Fruits> list = new ArrayList<>();
        for(FruitsRequest fruitsRequest : customerRequest.getFruitsRequest()){
            Fruits fruits = fruitsService.findFruitByName(fruitsRequest.getFruitName());
            if (fruits != null){
                list.add(fruits);
            }
        }
        Double totalAmount = 0.0;
        for(Fruits fruits : list){
            totalAmount = totalAmount + fruits.getPrice();
        }
        Sales sales = new Sales();
        sales.setFruits(list);
        sales.setTotalAmt(totalAmount);
        sales.setCustName(customerRequest.getCustName());
        sales.setCustMobNo(customerRequest.getCustMobNo());
        Sales resposne = new Sales();
        try{
            resposne = salesRepository.save(sales);
        }catch (Exception e){
            throw e;
        }
        return resposne;
    }

    @Override
    public List<Sales> getAllSalesDetails() {
        List<Sales> sales = new ArrayList<>();
        try{
            sales = salesRepository.findAll();
        }catch (Exception e){
            throw e;
        }
        return sales;
    }

    @Override
    public List<Sales> getSalesDetailsByCustomer(String name) {
        List<Sales> sales = new ArrayList<>();
        try{
            Query query = new Query().addCriteria(Criteria.where("custName").is(name));
            sales = mongoTemplate.find(query, Sales.class);
        }catch (Exception e){
            throw e;
        }
        return sales;
    }
}
