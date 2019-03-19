package com.example.network.repository;

import com.example.network.model.ProductUser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductUserRepository extends JpaRepository<ProductUser, Long> {

    ProductUser findByUserIdAndStatus(int userId, ProductUser.Status status);
    ProductUser findByUserIdAndProductId(int userId, int productId);
    List<ProductUser> findAllByStatus(ProductUser.Status status);
}
