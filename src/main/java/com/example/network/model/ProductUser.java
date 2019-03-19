package com.example.network.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ProductUser {

    public enum Status {active, inactive, ordered}

    @Id
    @GeneratedValue
    private int id;

    private int userId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product productId;

    private Boolean paymentActive;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade=CascadeType.MERGE, targetEntity = Payment.class)
    @JoinColumn(name = "paymentId")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Payment payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Boolean getPaymentActive() {
        return paymentActive;
    }

    public void setPaymentActive(Boolean paymentActive) {
        this.paymentActive = paymentActive;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}


