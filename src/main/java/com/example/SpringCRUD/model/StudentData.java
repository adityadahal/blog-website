package com.example.SpringCRUD.model;
//import  lombok.Getter;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "parents")
public class StudentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parentId;

    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private  String firstName;
    @Column(name="email")
    private String email;

    @Column(name = "dob")
    private  String dob;

    // TODO: add date of birth column


    public StudentData(int parentId, String email, String firstName, String lastName, String dob) {
        this.parentId = parentId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

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









