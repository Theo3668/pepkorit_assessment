package com.example.challenge.service;

import com.example.challenge.model.Sale;
import com.example.challenge.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MainServiceImpl implements MainService {

    private final double MAX_SALE_PRICE = 100;
    private final double MAX_PAYMENT_PRICE = 500;

    @Autowired
    SaleRepository saleRepository;

    @Override
    public void generateSale() {
        double salePrice = Math.round(Math.random() * MAX_SALE_PRICE * 100.0) / 100.0;
        double payment = Math.round((Math.random() * MAX_PAYMENT_PRICE + salePrice) * 100) / 100.0;
        double change = payment - salePrice;

        Sale newSale = new Sale(salePrice, payment, change);

        saleRepository.save(newSale);
    }

    @Override
    public Sale getSale(Long id) throws Exception {
        Optional<Sale> saleDb = this.saleRepository.findById(id);

        if (saleDb.isPresent()) {
            return saleDb.get();
        } else {
            throw new Exception("Record not found with id : " + id);
        }
    }

    @Override
    public List<Sale> getSales() {
        return this.saleRepository.findAll();
    }
}
