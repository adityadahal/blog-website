package com.example.SpringCRUD.controller;


import com.example.SpringCRUD.model.PaymentData;
import com.example.SpringCRUD.repo.PaymentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PaymentController {

    private  final PaymentRepo paymentRepo;

    private PaymentController(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @PostMapping("/payment")
    public  String createPayment(@RequestBody PaymentData paymentData){
        paymentRepo.save(paymentData);
        return  "Payment Saved successfully";
    }

    @GetMapping("/payment")

    public ResponseEntity<List<PaymentData>> getPayment(){
        List<PaymentData> paymentData = paymentRepo.findAll();
        return new ResponseEntity<>(paymentData, HttpStatus.OK);
    }



}
