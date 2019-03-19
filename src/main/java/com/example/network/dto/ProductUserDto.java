package com.example.network.dto;

public class ProductUserDto {
    private int userId;
    private int productId;
    private Boolean paymentActive;
    private float price;
    private String device;
    private String direction;
    private String technologies;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Boolean getPaymentActive() {
        return paymentActive;
    }

    public void setPaymentActive(Boolean paymentActive) {
        this.paymentActive = paymentActive;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }
}
