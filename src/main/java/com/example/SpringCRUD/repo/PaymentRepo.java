package com.example.SpringCRUD.repo;

import com.example.SpringCRUD.model.PaymentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository <PaymentData, Integer> {
}
