package com.fruitshop.controller;

import com.fruitshop.bean.Owner;
import com.fruitshop.bean.Status;
import com.fruitshop.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/saveowner")
    public String saveOwner(@RequestBody Owner owner){
        String response = "";
        try{
            Owner ownerResponse = ownerService.saveOwner(owner);
            if(ownerResponse == null){

            }
        }catch (Exception e){
            Status status = new Status("Exception while saving owner details",
                    "Exception while saving owner details, please try again", 400, false);
        }
        return "";
    }

    @GetMapping("/getownerdetails")
    public Owner getOwnerDetails(){
        Owner ownerResponse = new Owner();
        try{

        }catch (Exception e){
            Status status = new Status("Exception while getting owner details",
                    "Exception while getting owner details, please try again", 400, false);
        }
        return ownerResponse;
    }
}
