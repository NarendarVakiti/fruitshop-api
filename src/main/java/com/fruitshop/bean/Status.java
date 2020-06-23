package com.fruitshop.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Status {
    private String message;
    private String details;
    private int status;
    private boolean flag;
}
