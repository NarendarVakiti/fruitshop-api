package com.fruitshop.service;

import com.fruitshop.bean.Fruits;

import java.util.List;

public interface FruitsService {
    public Fruits addFruit(Fruits fruit);
    public List<Fruits> getFruitsDetails();
    public Fruits findFruitByName(String fruitName);
}
