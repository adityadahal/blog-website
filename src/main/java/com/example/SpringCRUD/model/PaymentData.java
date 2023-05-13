package com.example.SpringCRUD.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

@Table(name = "payment_records")
public class PaymentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int  id;
    private  String payment_method;
    private  String total_payed;

    public PaymentData(int id, String payment_method, String total_payed) {
        this.id = id;
        this.payment_method = payment_method;
        this.total_payed = total_payed;
    }

    public PaymentData() {
    }


}
