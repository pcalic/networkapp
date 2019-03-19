package com.example.network.repository;

import com.example.network.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByPaymentId(int paymentId);
}
