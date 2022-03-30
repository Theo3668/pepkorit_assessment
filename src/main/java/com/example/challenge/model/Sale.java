package com.example.challenge.model;

import javax.persistence.*;

import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreationTimestamp
    private Date createdAt;

    @Column(name="salePrice")
    private double salePrice;

    @Column(name="payment")
    private double payment;

    @Column(name="change")
    private double change;

    public Sale() {

    }

    public Sale(double salePrice, double payment, double change) {
        this.salePrice = salePrice;
        this.payment = payment;
        this.change = change;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getPayment() {
        return payment;
    }

    public double getChange() {
        return change;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void setChange(double change) {
        this.change = change;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("ID: ").append(id).append("\n");
        stringBuilder.append("Created At: ").append(createdAt.toString()).append("\n");
        stringBuilder.append("Sales Price: R").append(salePrice).append("\n");
        stringBuilder.append("Payment: R").append(payment).append("\n");
        stringBuilder.append("Change: R").append(change).append("\n");
        return stringBuilder.toString();
    }
}
