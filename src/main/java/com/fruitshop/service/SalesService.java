package com.fruitshop.service;

import com.fruitshop.bean.CustomerRequest;
import com.fruitshop.bean.Sales;

import java.util.List;

public interface SalesService {

    public Sales takeCustomerRequest(CustomerRequest customerRequest);
    public List<Sales> getAllSalesDetails();
    public List<Sales> getSalesDetailsByCustomer(String name);

}
