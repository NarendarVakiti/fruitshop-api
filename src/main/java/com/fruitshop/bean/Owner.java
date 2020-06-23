package com.fruitshop.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "owner")
public class Owner {

    private Integer ownerId;
    private String ownerName;
    private String email;
    private String password;

}
