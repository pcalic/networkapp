package com.example.network.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId", updatable = false, nullable = false)
    private int paymentId;
    private float price;

    @OneToMany(mappedBy = "payment", cascade= CascadeType.ALL, targetEntity = ProductUser.class)
    @OnDelete(action= OnDeleteAction.CASCADE)
    Set<ProductUser> productUsers;

    public Payment(){}

    public Payment(float price){
        this.price = price;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @JsonIgnore
    public Set<ProductUser> getProductUsers() {
        return productUsers;
    }

    @JsonIgnore
    public void setProductUsers(Set<ProductUser> productUsers) {
        this.productUsers = productUsers;
    }
}
