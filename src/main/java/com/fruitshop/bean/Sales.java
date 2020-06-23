package com.fruitshop.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sales")
public class Sales {
    private Integer salesID;
    private String custName;
    private String custMobNo;
    private List<Fruits> fruits;
    private Double totalAmt;
}
