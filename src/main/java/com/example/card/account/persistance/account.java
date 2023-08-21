package com.example.card.account.persistance;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = ProjectConst.DB_PREFIX + "card")
@DiscriminatorValue(value = "1")

public class account extends GenericEntityImpl{

    @Id
    @Column(name = "id", columnDefinition = OracleUtility.COLUMN_DEFINITION_PRIMARY_KEY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "user")
    private Integer user;

    @Column(name = "name")
    private String name();

    @Column(name = "family")
    private String family;
















}
