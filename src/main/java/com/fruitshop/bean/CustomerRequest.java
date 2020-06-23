package com.fruitshop.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private List<FruitsRequest> fruitsRequest;
    private String custName;
    private String custMobNo;
}
