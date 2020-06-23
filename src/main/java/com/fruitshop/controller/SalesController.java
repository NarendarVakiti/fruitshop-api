package com.fruitshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fruitshop.bean.CustomerRequest;
import com.fruitshop.bean.Sales;
import com.fruitshop.bean.Status;
import com.fruitshop.service.SalesService;
//import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping("/customerrequest")
    public String takeCustomerRequest(@RequestBody CustomerRequest customerRequest) throws JsonProcessingException {
        String response = "";
        ObjectMapper mapper = new ObjectMapper();
        try{
            Sales sales = salesService.takeCustomerRequest(customerRequest);
            //response = new Gson().toJson(sales);
            response = mapper.writeValueAsString(sales);
            if(sales == null){
                Status status = new Status("Details not found on your request",
                        "Details not found on your request, please try again", 200, false);
                //response = new Gson().toJson(status);
                response = mapper.writeValueAsString(status);
            }
        }catch (Exception e){
            Status status = new Status("Exception while taking customer request",
                    "Exception while taking customer request, please try again", 400, false);
            //response = new Gson().toJson(status);
            response = mapper.writeValueAsString(status);
        }
        return response;
    }

    @GetMapping("/getallsalesdetails")
    public String getAllSalesDetails() throws JsonProcessingException {
        String response = "";
        ObjectMapper mapper = new ObjectMapper();
        try{
            List<Sales> sales = salesService.getAllSalesDetails();
            //response = new Gson().toJson(sales);
            response = mapper.writeValueAsString(sales);
            if(sales.isEmpty()){
                Status status = new Status("Sales Details not found on your request",
                        "Sales Details not found on your request, please try again", 200, false);
                //response = new Gson().toJson(status);
                response = mapper.writeValueAsString(status);
            }

        }catch(Exception e){
            Status status = new Status("Exception while getting sales report",
                    "Exception while getting sales report, please try again", 400, false);
            //response = new Gson().toJson(status);
            response = mapper.writeValueAsString(status);
        }
        return response;
    }

    @GetMapping("/getsalesdetailsbycustomer/{name}")
    public String getSalesDetailsByCustomer(@PathVariable String name) throws JsonProcessingException {
        String response = "";
        ObjectMapper mapper = new ObjectMapper();
        try{
            List<Sales> sales = salesService.getSalesDetailsByCustomer(name);
            //response = new Gson().toJson(sales);
            response = mapper.writeValueAsString(sales);
            if(sales.isEmpty()){
                Status status = new Status("Sales Details not found for customer : "+name,
                        "Sales Details not found on your request, please try again", 200, false);
                //response = new Gson().toJson(status);
                response = mapper.writeValueAsString(status);
            }

        }catch(Exception e){
            Status status = new Status("Exception while getting sales report",
                    "Exception while getting sales report, please try again", 400, false);
            //response = new Gson().toJson(status);
            response = mapper.writeValueAsString(status);
        }
        return response;
    }
}
