package com.example.card.Email.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "sendemail")
public class SimpleMailMessage {

    private String text;
    private String subject;
    private String from;
    private String to;


}
