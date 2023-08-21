package com.example.card.customer.persistance;

import GenericEntityImpl.GenericEntityImpl;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = ProjectConst.DB_PREFIX+"Customer")
public class Customer extends GenericEntityImpl {

    @Id
    @Column(name = "id", columnDefinition = OracleUtility.COLUMN_DEFINITION_PRIMARY_KEY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;


}
