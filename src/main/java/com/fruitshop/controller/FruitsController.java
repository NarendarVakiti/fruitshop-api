package com.fruitshop.controller;

import com.fruitshop.bean.Fruits;
import com.fruitshop.bean.Owner;
import com.fruitshop.bean.Status;
import com.fruitshop.service.FruitsService;
import com.fruitshop.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FruitsController {

    @Autowired
    private FruitsService fruitsService;

    @PostMapping("/addfruit")
    public String addFruit(@RequestBody Fruits fruits){
        String response = "";
        try{
            Fruits fruit = fruitsService.addFruit(fruits);

            if(fruit == null){

            }
        }catch (Exception e){
            Status status = new Status("Exception while adding fruit details",
                    "Exception while adding fruit details, please try again", 400, false);
        }
        return "";
    }

    @GetMapping("/getfruitdetails")
    public List<Fruits> getFruitDetails(){
        List<Fruits> fruitsList = new ArrayList<>();
        try{
            fruitsList = fruitsService.getFruitsDetails();
        }catch (Exception e){
            Status status = new Status("Exception while getting fruit details",
                    "Exception while getting fruit details, please try again", 400, false);
        }
        return fruitsList;
    }

    @GetMapping("/findFruitByName/{fruit}")
    public Fruits findFruitByName(@PathVariable String fruitName){
        Fruits fruit = new Fruits();
        try{
            fruit = fruitsService.findFruitByName(fruitName);
        }catch (Exception e){
            Status status = new Status("Exception while getting fruit details",
                    "Exception while getting fruit details, please try again", 400, false);
        }
        return fruit;
    }
}
