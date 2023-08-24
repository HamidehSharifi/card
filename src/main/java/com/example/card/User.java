package com.example.card;

import javax.persistence.*;

@Entity
@Table(name = "user_sign")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "otp")
    private String otp;

}
