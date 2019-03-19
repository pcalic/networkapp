package com.example.network.service;

import com.example.network.dto.ProductUserDto;

import java.util.List;

public interface ProductUserService {
    ProductUserDto findActiveProductForUser(int userId);
    List<ProductUserDto> findActiveProductForAllUsers();
    void addPayment(int userId, float price);
    void editPayment(int userId, int paymentId, float price);
    void deletePayment(int userId, int paymentId);
}
