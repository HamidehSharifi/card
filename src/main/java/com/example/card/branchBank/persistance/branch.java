package com.example.card.branchBank.persistance;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class branch {
    @Id
    @Column(name = "id", columnDefinition = OracleUtility.COLUMN_DEFINITION_PRIMARY_KEY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;



}
