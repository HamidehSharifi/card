package com.example.card.employer.persistance;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private Integer userName;

    @Column(name = " name")
    private String name;

}

