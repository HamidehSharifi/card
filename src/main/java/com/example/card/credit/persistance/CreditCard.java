package com.example.card.credit.persistance;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = ProjectCon)
public class CreditCard extends GenericEntity{
    @Id
    @Column(name = "id", columnDefinition = OracleUtility.COLUMN_DEFINITION_PRIMARY_KEY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "user_id ")
    private Integer userId;



}
