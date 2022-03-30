package com.example.challenge.service;

import com.example.challenge.model.Sale;

import java.util.List;

public interface MainService {
    public void generateSale();
    public Sale getSale(Long id) throws Exception;
    public List<Sale> getSales();
}
