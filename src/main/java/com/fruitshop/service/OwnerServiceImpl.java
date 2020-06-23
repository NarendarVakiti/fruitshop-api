package com.fruitshop.service;

import com.fruitshop.bean.Owner;
import com.fruitshop.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owner saveOwner(Owner owner) {
        Owner response = new Owner();
        try{
            response = ownerRepository.save(owner);
        }catch (Exception e){
            throw e;
        }
        return response;
    }

    @Override
    public List<Owner> getOwnerDetails() {
        List<Owner> ownerList = new ArrayList<>();
        try{
            ownerList = ownerRepository.findAll();
        }catch (Exception e){
            throw e;
        }
        return ownerList;
    }
}
