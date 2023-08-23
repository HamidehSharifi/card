package com.example.card.Email.persistance;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Data
@Table(name = "role")
public class Role {

}
