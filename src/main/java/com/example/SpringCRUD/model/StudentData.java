package com.example.SpringCRUD.model;
//import  lombok.Getter;

import jakarta.persistence.*;

@Entity
@Table(name = "parents")
public class StudentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parentId;

    @Column(name="LastName")
    private String lastName;
    @Column(name="FirstName")
    private  String firstName;
    @Column(name="Email")
    private String email;


    public StudentData(int parentId, String email, String firstName, String lastName) {
        this.parentId = parentId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public StudentData() {

    }

    @Override
    public String toString() {
        return "StudentData{" +
                "parentId=" + parentId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}









