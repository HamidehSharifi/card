package com.example.card.Email.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "seller")
public class Seller {


    private String firstName;


    private String middleName;
    private String lastName;
    private String active;
    private String deleted;
    private String expired;
    private String locked;
    private String InvalidAttemptCont;
    private String Password;
    private String Email;
    private String companyContact;
    private String companyName;
    private String Gst;



}
