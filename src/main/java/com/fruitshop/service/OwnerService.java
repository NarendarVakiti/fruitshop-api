package com.fruitshop.service;

import com.fruitshop.bean.Owner;

import java.util.List;

public interface OwnerService {
    public Owner saveOwner(Owner owner);
    public List<Owner> getOwnerDetails();
}
