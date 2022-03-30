package com.example.challenge;

import com.example.challenge.model.Sale;
import com.example.challenge.service.MainService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ChallengeApplicationTests {
    @Autowired
    private MainService mainService;

    public void setup() {
        for (int i = 0; i < 100; i++) {
            this.mainService.generateSale();
        }
    }

    @Test
    // Test 100 Generated Sales
    public void testConstraintsOnAllSales() {
        setup();

        List<Sale> sales = mainService.getSales();
        for (Sale sale :
                sales) {
            assert sale != null;
            assert sale.getSalePrice() < 100;
            assert sale.getSalePrice() < sale.getPayment();
            assert sale.getPayment() - sale.getSalePrice() == sale.getChange();
            System.out.println(sale.toString());
        }
    }
}
