package com.example.SpringCRUD.dto;

public class StudentDataDto {
    private String lastName;
    private  String firstName;
    private String email;
    private  String dob;
    private int paymentId;

    public StudentDataDto(String lastName, String firstName, String email, String dob, int paymentId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.dob = dob;
        this.paymentId = paymentId;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
}
